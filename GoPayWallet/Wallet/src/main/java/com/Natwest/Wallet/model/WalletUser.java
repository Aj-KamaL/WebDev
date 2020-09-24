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
//    add card details per user today


    public WalletUser(String userId, List<Transaction> transactionList) {
        this.userId = userId;
        this.inWalletAmount.put("C1",0.0);
        this.inWalletAmount.put("C2",0.0);
        this.inWalletAmount.put("C3",0.0);
        this.inWalletAmount.put("C4",0.0);
        this.inWalletAmount.put("C5",0.0);
        this.inWalletAmount.put("C6",0.0);
        this.transactionList = transactionList;
    }

    public WalletUser() {
        this.inWalletAmount.put("C1",0.0);
        this.inWalletAmount.put("C2",0.0);
        this.inWalletAmount.put("C3",0.0);
        this.inWalletAmount.put("C4",0.0);
        this.inWalletAmount.put("C5",0.0);
        this.inWalletAmount.put("C6",0.0);
        this.transactionList = new ArrayList<>();
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

    @Override
    public String toString() {
        return "WalletUser{" +
                "userId=" + userId +
                ", inWalletAmount=" + inWalletAmount +
                ", transactionList=" + transactionList +
                '}';
    }
}
