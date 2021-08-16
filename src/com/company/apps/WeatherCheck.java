package com.company.apps;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XMLParserConfiguration;

public class WeatherCheck {

    public static void weatherCheck() throws IOException {

        System.out.println("Welcome to the simple weather check application!\nEnter the city name to start.");

        Scanner in = new Scanner(System.in);
        String location = in.nextLine().trim();
        System.out.println(getWeatherData(location));
    }

    public static String getWeatherData(String location) throws IOException {
        JSONObject weatherData = new JSONObject();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?units=metric&q=" + location + "&appid=fda67d535995262be873f7271e1e7cee");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        //checking if API can fetch the data
        if (responsecode != 200){
            throw new RuntimeException("HTTPResponseCode: " + responsecode);
        }
        else {
            String inline = "";
            //opening a connection
            Scanner scanner = new Scanner (url.openStream());
            //populating the data from API
            while (scanner.hasNext()){
                inline += scanner.nextLine();
                //System.out.println(inline);
            }
            //we're done here so closing the connection
            scanner.close();

            //since we have the data, let's parse it to something more usable

            weatherData = new JSONObject(inline);
            //and then, finally, output the result to the user.
            System.out.println("Current temperature: "+weatherData.getJSONObject("main").getInt("temp") +" Celsius\nFeels like: "+weatherData.getJSONObject("main").getInt("feels_like") +" Celsius");
        }
        return null;
    }
}
