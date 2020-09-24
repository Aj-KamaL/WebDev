package com.Natwest.Wallet.model;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private String transactionType;
    private String mssg;
    private double amount;
//    add contact here by Friday
    private String currency;
    private Date dateOfTransaction;

    public Transaction(int transactionId, String transactionType, String mssg, double amount, String currency, Date dateOfTransaction) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.mssg = mssg;
        this.amount = amount;
        this.currency = currency;
        this.dateOfTransaction = dateOfTransaction;
    }

    public Transaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", mssg='" + mssg + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }
}
