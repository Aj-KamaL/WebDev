package com.Natwest.Wallet.service;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.Natwest.Wallet.exception.InsufficientFundExeption;
import com.Natwest.Wallet.exception.TransactionFailedException;
import com.Natwest.Wallet.model.Card;
import com.Natwest.Wallet.model.Transaction;
import com.Natwest.Wallet.model.WalletUser;
import com.Natwest.Wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{
    private WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository=walletRepository;
    }

    @Override
    public boolean createWalletUser(String userId, String nameOnCard, String expiryDate, String cvv, String cardNumber) {
        WalletUser newWalletUser = new WalletUser();
        newWalletUser.setUserId(userId);
        Card card =new Card(nameOnCard,expiryDate,cvv,cardNumber);
        newWalletUser.setCard(card);
        WalletUser insertedWalletUser = walletRepository.insert(newWalletUser);
        if(insertedWalletUser==null)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean debit(String userId, double amount, String currency) throws TransactionFailedException, InsufficientFundExeption {
        try{
            WalletUser walletUser = walletRepository.findById(userId).get();
            Map<String,Double> wallet = walletUser.getInWalletAmount();
            List<Transaction> listOfTransaction=walletUser.getTransactionList();
            double amountInWallet = wallet.get(currency);
            if(amountInWallet>=amount){
                wallet.put(currency,amountInWallet-amount);
                Transaction transaction = new Transaction(listOfTransaction.size()+1,"Debit","Money Deducted from the Wallet",amount,currency,new java.util.Date(System.currentTimeMillis()));
                listOfTransaction.add(transaction);
                walletUser.setTransactionList(listOfTransaction);
                walletUser.setInWalletAmount(wallet);
                walletRepository.save(walletUser);
                return true;
            }
            else{
                Transaction transaction = new Transaction(listOfTransaction.size()+1,"Error","Insufficient Funds",amount,currency,new java.util.Date(System.currentTimeMillis()));
                listOfTransaction.add(transaction);
                walletUser.setTransactionList(listOfTransaction);
                walletRepository.save(walletUser);
                throw new InsufficientFundExeption("Insufficient Funds");
            }
        }
        catch (NoSuchElementException e)
        {
            throw new TransactionFailedException("Transaction Failed");
        }
    }

    @Override
    public boolean credit(String userId, double amount, String currency) throws TransactionFailedException {
        try{
            WalletUser walletUser = walletRepository.findById(userId).get();
            Map<String,Double> wallet = walletUser.getInWalletAmount();
            List<Transaction> listOfTransaction=walletUser.getTransactionList();
            System.out.println(currency);
            double amountInWallet = wallet.get(currency);

            wallet.put(currency,amountInWallet+amount);
            Transaction transaction = new Transaction(listOfTransaction.size()+1,"Credit","Money Added to the Wallet",amount,currency,new java.util.Date(System.currentTimeMillis()));
            listOfTransaction.add(transaction);
            walletUser.setTransactionList(listOfTransaction);
            walletUser.setInWalletAmount(wallet);
            walletRepository.save(walletUser);
            return true;
        }
        catch (NoSuchElementException e)
        {
            throw new TransactionFailedException("Transaction Failed");
        }
    }

    @Override
    public Map<String,Double> getWallet(String userId) throws TransactionFailedException {
        try{
            WalletUser walletUser = walletRepository.findById(userId).get();
            Map<String,Double> walletAmount=walletUser.getInWalletAmount();
            return walletAmount;
        }
        catch (NoSuchElementException e)
        {
            throw new TransactionFailedException("Transaction Failed");
        }
    }

    @Override
    public List<Transaction> getAllTransactionByUserId(String userId) throws TransactionFailedException {
        try{
            WalletUser walletUser = walletRepository.findById(userId).get();
            List<Transaction> listOfTransaction=walletUser.getTransactionList();
            return listOfTransaction;
        }
        catch (NoSuchElementException e)
        {
            throw new TransactionFailedException("Transaction Failed");
        }
    }

    @Override
    public Card getCardByUserId(String userId) throws TransactionFailedException {
        try{
            WalletUser walletUser = walletRepository.findById(userId).get();
            Card card =walletUser.getCard();
            return card;
        }
        catch (NoSuchElementException e)
        {
            throw new TransactionFailedException("Transaction Failed");
        }
    }
}