package com.FluffyCurrency.Project5;// this is a crypto object that stores the enum type.  This is a way for us to save peoples favorites

import org.springframework.stereotype.Component;

public class Crypto {

    public String cryptoType;
    public Crypto(String cryptoType){
        this.cryptoType = cryptoType;
    }

}
