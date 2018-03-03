package com.FluffyCurrency.Project5;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

    private String id;
    private Map<Integer, Transaction> transMap;
    private ArrayList<Crypto> cryptoFavs;

    public Person(String id) {
        this.id = id;
        this.transMap = new HashMap<>();
        this.cryptoFavs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Transaction getTransaction(int transNum) {
        return transMap.get(transNum);
    }

    public List<Transaction> getTransactionArrayList() {
        List<Transaction> list = new ArrayList<>(transMap.values());
        return list;
    }

    public boolean addTransaction(String cryptoID, double quantity, double price, int transNum) {
        Transaction trans = new Transaction(cryptoID, quantity, price, transNum);
        transMap.put(transNum, trans);
        return true;
    }

    public boolean deleteTransaction(int transNum) {
        if (transMap.containsKey(transNum)) {
            transMap.remove(transNum);
        }
        return true;
    }


    private boolean addCryptoFav(Crypto crypto) {
        if (!cryptoFavs.contains(crypto)) {
            cryptoFavs.add(crypto);
        }
        return true;
    }

    private boolean deleteCryptoFav(Crypto crypto) {
        if (cryptoFavs.contains(crypto)) {
            cryptoFavs.remove(crypto);
        }
        return true;
    }

    private boolean clearCryptoFav() {
        cryptoFavs.clear();
        return true;
    }
}
