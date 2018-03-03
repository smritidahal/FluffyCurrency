package com.FluffyCurrency.Project5;

import com.google.gson.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//API CALLS TO COINMARKETCAP.COM

@Component
public class Market {

    public double getCurrentPrice(String cryptoID) throws MalformedURLException, IOException {
        try {

            URL url = new URL(String.format("https://api.coinmarketcap.com/v1/ticker/%s/", cryptoID));
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            Gson gson = new Gson();
            CryptoCoin[] arr = gson.fromJson(new InputStreamReader((InputStream) request.getContent()),
                    CryptoCoin[].class);

            return arr[0].price_usd;

        } catch (MalformedURLException e) {
            System.out.println("*** BAD API URL CALL IN MARKET **\n\n");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("*** HTTP CONNECTION FAILED IN MARKET **\n\n");
            e.printStackTrace();
        }

        return -1.0;
    }

}

class CryptoCoin {
    double price_usd;
}
