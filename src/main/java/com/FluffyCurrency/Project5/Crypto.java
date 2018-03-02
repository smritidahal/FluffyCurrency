package com.FluffyCurrency.Project5;// this is a crypto object that stores the enum type.  This is a way for us to save peoples favorites

import org.springframework.stereotype.Component;


@Component
public class Crypto {

    private CryptoType cryptoType;
    public Crypto(CryptoType cryptoType){
        this.cryptoType = cryptoType;
    }

}
