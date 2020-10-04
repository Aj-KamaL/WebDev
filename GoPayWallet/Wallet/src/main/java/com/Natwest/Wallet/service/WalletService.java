package com.Natwest.Wallet.service;

import com.Natwest.Wallet.exception.InsufficientFundExeption;
import com.Natwest.Wallet.exception.TransactionFailedException;
import com.Natwest.Wallet.model.Card;
import com.Natwest.Wallet.model.Transaction;

import java.util.List;
import java.util.Map;

public interface WalletService {
    boolean createWalletUser(String userId, String nameOnCard, String expiryDate, String cvv, String cardNumber);

    boolean debit(String userId, double amount,String currency) throws TransactionFailedException, InsufficientFundExeption;

    boolean credit(String userId, double amount,String currency) throws TransactionFailedException;

    Map<String,Double> getWallet(String userId) throws TransactionFailedException;
    List<Transaction> getAllTransactionByUserId(String userId) throws TransactionFailedException;
    Card getCardByUserId(String userId) throws TransactionFailedException;
}
