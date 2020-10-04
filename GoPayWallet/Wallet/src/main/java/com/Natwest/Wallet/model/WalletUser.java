package com.Natwest.Wallet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
public class WalletUser {
    @Id
    private String userId;
    private Map<String,Double> inWalletAmount=new HashMap<>();
    private List<Transaction> transactionList;
    private Card card;

    public WalletUser(String userId, List<Transaction> transactionList) {
        this.userId = userId;
        this.inWalletAmount.put("INR",0.0);
        this.inWalletAmount.put("CHF",0.0);
        this.inWalletAmount.put("GBP",0.0);
        this.inWalletAmount.put("USD",0.0);
        this.inWalletAmount.put("CAD",0.0);
        this.inWalletAmount.put("EUR",0.0);
        this.transactionList = transactionList;
        card=new Card();
    }

    public WalletUser() {
        this.inWalletAmount.put("INR",0.0);
        this.inWalletAmount.put("CHF",0.0);
        this.inWalletAmount.put("GBP",0.0);
        this.inWalletAmount.put("USD",0.0);
        this.inWalletAmount.put("CAD",0.0);
        this.inWalletAmount.put("EUR",0.0);
        this.transactionList = new ArrayList<>();
        card=new Card();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Double> getInWalletAmount() {
        return inWalletAmount;
    }

    public void setInWalletAmount(Map<String, Double> inWalletAmount) {
        this.inWalletAmount = inWalletAmount;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "WalletUser{" +
                "userId='" + userId + '\'' +
                ", inWalletAmount=" + inWalletAmount +
                ", transactionList=" + transactionList +
                ", card=" + card +
                '}';
    }
}
