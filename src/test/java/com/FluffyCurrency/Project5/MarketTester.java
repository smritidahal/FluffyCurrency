package com.FluffyCurrency.Project5;

import com.sun.xml.internal.rngom.nc.AnyNameExceptNameClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarketTester{


    @Autowired
    private Market market;

    @Test
    public void testMarket() throws IOException {

        double result = market.getCurrentPrice("bitcoin");
        System.out.println(result);
        assert result != -1.0;
    }
//    @Test(expected = Exception.class)
//    public void testIOException() throws IOException {
//        double result1 = market.getCurrentPrice("BadCoin");
//    }


}
