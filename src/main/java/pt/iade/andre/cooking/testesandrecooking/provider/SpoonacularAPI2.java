/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.iade.andre.cooking.testesandrecooking.provider;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pt.iade.andre.cooking.testesandrecooking.model.Recipe;

/**
 *
 * @author rv_ra
 */
public class SpoonacularAPI2 {
    
    public static List<Recipe> getRandomRecipe() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=3")
            .get()
            .addHeader("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "b8bbd32f2amshbf846518e4124e7p13511ajsn8314fc210877")
            .build();
        
        Response response = null;
        try {
            response = client.newCall(request).execute();
        }
        catch(IOException ex) {
            System.err.println("Esta bosta falhou!");
            ex.printStackTrace();
        }
        
        if(response != null) {
            String responseString = response.body().string();
            System.out.println("Response String:\n" + responseString);
            Type typeToken = new TypeToken<ArrayList<Recipe>>() {}.getType();
            
            Gson gson = new Gson();
            List<Recipe> outputList = gson.fromJson(responseString, typeToken);
            
            return outputList;
        }
        
        return null;
    }
}
