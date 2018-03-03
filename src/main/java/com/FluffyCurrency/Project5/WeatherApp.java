/*
Author:     Omar Sarhan
Class:      CSSE490 - W18 - Cloud Computing
Date:       Jan 18, 2018
Assignment: Program 2 - REST
*/
import com.google.gson.*;
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;

public class WeatherApp {

    public static void main (String [] args) throws IOException{
        System.out.println("\nWelcome to Omar's Weather App!\n");
        String loop = "yes";
        while(loop.equals("yes")) {

            String cityName = requestCity();
            String requestEndpoint = urlMaker(cityName);

            URL url = new URL(requestEndpoint);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            System.out.println(requestEndpoint);

            try {
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject weatherObject = root.getAsJsonObject();
                getWeather(weatherObject,jp);//tests city is valid before displaying results
                displayResults(weatherObject, jp);
                loop = "no";
            } catch (Exception e) {
                System.out.println("***City Not Found***\n\n");
            }
        }
    }

    public static String requestCity(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input options for location: \n" +
                "   - City Name (Seattle,USA or Seattle)\n" +
                "   - Zip Code (98011)\n" +
                "\nPlease enter your City or Zip: ");
        return in.nextLine();
    }

    public static String urlMaker(String city) {
        return "http://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&units=imperial&APPID=3ddb3710f6cad3fa3519ae0d27f6c4ad";
    }

    public static String getCity(JsonObject weatherObject){
        return weatherObject.get("name").getAsString();
    }
    public static String getCountry(JsonObject weatherObject){
        return weatherObject.get("sys").getAsJsonObject().get("country").getAsString();
    }
    public static double getTemp(JsonObject weatherObject){
        return weatherObject.get("main").getAsJsonObject().get("temp").getAsDouble();
    }
    public static double getTempMin(JsonObject weatherObject){
        return weatherObject.get("main").getAsJsonObject().get("temp_min").getAsDouble();
    }
    public static double getTempMax(JsonObject weatherObject){
        return weatherObject.get("main").getAsJsonObject().get("temp_max").getAsDouble();
    }
    public static String getWeather(JsonObject weatherObject, JsonParser jp){
        String weather = weatherObject.get("weather").toString();
        String weatherJson = weather.substring(1,weather.length()-1);
        JsonElement weatherRoot = jp.parse(weatherJson);
        return weatherRoot.getAsJsonObject().get("main").getAsString();
    }
    public static String getWeatherDescription(JsonObject weatherObject, JsonParser jp){
        String weather = weatherObject.get("weather").toString();
        String weatherJson = weather.substring(1, weather.length() - 1);
        JsonElement weatherRoot = jp.parse(weatherJson);
        return weatherRoot.getAsJsonObject().get("description").getAsString();
    }
    public static double getWind(JsonObject weatherObject){
        return weatherObject.get("wind").getAsJsonObject().get("speed").getAsDouble();
    }
    public static double getHumidity(JsonObject weatherObject){
        return weatherObject.get("main").getAsJsonObject().get("humidity").getAsDouble();
    }
    public static double getCloudiness(JsonObject weatherObject) {
        return weatherObject.get("clouds").getAsJsonObject().get("all").getAsDouble();
    }

    public static void displayResults(JsonObject weatherObject, JsonParser jp){
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        String border = "+-----------------------------------------------------------+";
        String header = "+===========================================================+";

        System.out.println(header);
        System.out.printf("||     Location:\t\t%s,%s  \n", getCity(weatherObject), getCountry(weatherObject));
        System.out.println(border);
        System.out.printf("||     Weather:\t\t\t%s (%s)  \n", getWeather(weatherObject, jp),
                getWeatherDescription(weatherObject, jp));
        System.out.println(border);
        System.out.printf("|| Current Temp(F): %s  | max: %s  | min: %s \n",
                getTemp(weatherObject), getTempMax(weatherObject), getTempMin(weatherObject));
        System.out.println(border);
        System.out.printf("||  Wind(mph): %s  || Humidity: %s  || Cloudiness: %s  \n", getWind(weatherObject),
                percentFormat.format(getHumidity(weatherObject)/100),
                percentFormat.format(getCloudiness(weatherObject)/100));
        System.out.println(header);
    }
}
