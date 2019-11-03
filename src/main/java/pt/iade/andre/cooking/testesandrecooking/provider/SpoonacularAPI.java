package pt.iade.andre.cooking.testesandrecooking.provider;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author rv_ra
 */
public class SpoonacularAPI {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String API_BASE_URL = "https://api.spoonacular.com";
    private static final String API_KEY = "617b9fe26c394bfebf78786cd5cef865";
    
    public static String getReceitaById(String receitaId) throws Exception {
        String urlString = API_BASE_URL + "/recipes/random"
                + "?apiKey=617b9fe26c394bfebf78786cd5cef865"
                + "?number=1";
        
        URL urlObject = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()) );
        String inputLine;
        StringBuilder response = new StringBuilder();
        
        while( (inputLine = in.readLine()) != null ) {
            response.append(inputLine);
        }
        in.close();
        
        System.out.println("Response: " + response.toString());
        return response.toString();
    }
}
