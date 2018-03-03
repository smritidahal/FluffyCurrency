package com.FluffyCurrency.Project5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Nucleus {

    @Autowired
    private DynamoDBService dynamoDBService;


    public int getTransactionNumber() {

        return -1;
    }

    public boolean addTransactionToUserAccount(String cryptoID, double price, double amount) {
        return dynamoDBService.loadTransToDB();
    }

    public boolean deleteTransactionFromUserAccount(String transNum) {
        return dynamoDBService.removeTransFromDB();
    }


    public boolean deleteAllTransactionsFromUserAccount() {
        return dynamoDBService.removeAllTransFromDB();
    }

    public boolean addFavToUserAccount() {
        return dynamoDBService.loadFavToDB();
    }

    public boolean removeFavFromUserAccount() {
        return dynamoDBService.removeFavFromDB();
    }

    public boolean removeAllFavFromUserAccount() {
        return dynamoDBService.removeAllFavFromDB();
    }


    public boolean updatePieChart() {
        //get User

        return true;
    }


}
