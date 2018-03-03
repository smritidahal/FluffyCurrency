package com.FluffyCurrency.Project5;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

        String requestEndpoint = urlMaker(cryptoID);

        URL url = new URL(requestEndpoint);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();



        try {

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            String price = root.getAsString();
            System.out.println(price);


            String crypto = root.getAsString();

            String cryptoJSON = crypto.substring(1,crypto.length()-1);
            JsonElement crypoRoot = jp.parse(cryptoJSON);
            return crypoRoot.getAsJsonObject().get("price_usd").getAsDouble();


        } catch (Exception e) {
            System.out.println("***crypto Not Found***\n\n");
            e.printStackTrace();
        }

        return 0.0;
    }

    private String urlMaker(String input) {

        return String.format("https://api.coinmarketcap.com/v1/ticker/%s/", input);
    }


}
