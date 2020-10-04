package com.Natwest.Wallet.model;

public class Card {
    private String nameOnCard;
    private String expiryDate;
    private String cardNumber;
    private String cvv;

    public Card(String nameOnCard, String expiryDate, String cardNumber, String cvv) {
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public Card() {
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Card{" +
                "nameOnCard='" + nameOnCard + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
