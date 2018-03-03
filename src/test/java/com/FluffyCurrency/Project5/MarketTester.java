package com.FluffyCurrency.Project5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarketTester{


    @Autowired
    private Market market;

    @Test
    public void testMarket() throws IOException {

        double result = market.getCurrentPrice("bitcoin");

        assert result != 0.0;

    }


}
