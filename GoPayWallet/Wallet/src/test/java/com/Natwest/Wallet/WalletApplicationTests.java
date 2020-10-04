package com.Natwest.Wallet;

import com.Natwest.Wallet.model.Card;
import com.Natwest.Wallet.model.Transaction;
import com.Natwest.Wallet.model.WalletUser;
import com.Natwest.Wallet.repository.WalletRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class WalletApplicationTests {

	@Autowired
	private WalletRepository walletRepository;

	private Card card;
	private Transaction transaction;
	private WalletUser walletUser;
	private List<Transaction> transactionList = null;


	@Before
	public void setUp() throws Exception {

		card = new Card();
		card.setNameOnCard("JK");
		card.setCardNumber("123467890");
		card.setExpiryDate("12/22");
		card.setCvv("111");

		transactionList = new ArrayList<>();

		transaction =new Transaction();
		transaction.setTransactionId(transactionList.size()+1);
		transaction.setTransactionType("Credit");
		transaction.setAmount(100);
		transaction.setCurrency("INR");
		transaction.setMssg("");
		transaction.setDateOfTransaction(new Date());

		transactionList.add(transaction);

		Map<String,Double> inWalletAmount=new HashMap<>();
		inWalletAmount.put("INR",100.0);
		inWalletAmount.put("CHF",0.0);
		inWalletAmount.put("GBP",0.0);
		inWalletAmount.put("USD",0.0);
		inWalletAmount.put("CAD",0.0);
		inWalletAmount.put("EUR",0.0);

		walletUser =new WalletUser();
		walletUser.setCard(card);
		walletUser.setTransactionList(transactionList);
		walletUser.setInWalletAmount(inWalletAmount);
		walletUser.setUserId("1");
		walletRepository.insert(walletUser);

	}

	@After
	public void tearDown() throws Exception {
		walletRepository.deleteAll();
	}

	@Test
	public void createTransactionTest() {
		List<Transaction> allTransactions = walletRepository.findById("1").get().getTransactionList();
		Assert.assertEquals(transactionList.get(0).getTransactionId(), allTransactions.get(0).getTransactionId());
	}


	@Test
	public void updateTransactionTest() {
		List<Transaction> allTransactions = walletRepository.findById("1").get().getTransactionList();
		Assert.assertEquals(transactionList.get(0).getTransactionId(), allTransactions.get(0).getTransactionId());
		Iterator iterator = allTransactions.listIterator();
		while (iterator.hasNext()) {
			transaction = (Transaction) iterator.next();
			if (transaction.getTransactionId() == 1)
				transaction.setMssg("Credit of 100");
		}
		walletUser.setTransactionList(allTransactions);
		walletRepository.save(walletUser);
		allTransactions = walletRepository.findById("1").get().getTransactionList();
		Assert.assertEquals("Credit of 100", allTransactions.get(0).getMssg());
	}

	@Test
	public void getAllTransactionsByUserId() {
		List<Transaction> allTransactions = walletRepository.findById("1").get().getTransactionList();
		Assert.assertEquals(1, allTransactions.size());
	}
}
