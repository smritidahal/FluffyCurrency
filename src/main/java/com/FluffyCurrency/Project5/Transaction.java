package com.FluffyCurrency.Project5;

import org.springframework.stereotype.Component;

//com.FluffyCurrency.Project5.Transaction saves transaction details the user.
@Component
public class Transaction {

    private String cryptoID;
    private double quantity;
    private double price;
    private int transNum;



    public Transaction(String cryptoID, double quantity, double price, int transNum){
        this.cryptoID = cryptoID;
        this.quantity = quantity;
        this.price = price;
        this.transNum = transNum;
    }


    public String getCryptoID() {
        return cryptoID;
    }

    public void setCryptoID(String cryptoID) {
        this.cryptoID = cryptoID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
