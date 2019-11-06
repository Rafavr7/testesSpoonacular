package pt.iade.andre.cooking.testesandrecooking.provider;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

import pt.iade.andre.cooking.testesandrecooking.exceptions.BadRequestException;
import pt.iade.andre.cooking.testesandrecooking.model.Recipe;
import pt.iade.andre.cooking.testesandrecooking.model.utils.RecipeResponse;
import pt.iade.andre.cooking.testesandrecooking.utils.ApiConstants;

public class RecipesProvider {
    
    /**
     * Class Constants
     */
    private static final String PROVIDER_BASE_URL = ApiConstants.RAPID_API_BASE_URL + "/recipes";
    
    public static Recipe[] getRandomRecipes(Integer number, Boolean limitLicense,
            String tags) {
        
        StringBuilder requestURL = new StringBuilder();
        requestURL.append(PROVIDER_BASE_URL).append("/random");
        
        String urlParameters = "";
        if(number != null && number > 0) {
            urlParameters += "number=" + number;
        }
        if(limitLicense != null) {
            if(!urlParameters.isEmpty()) {
                urlParameters += "&";
            }
            urlParameters += "limitLicense=" + limitLicense;
        }
        if(tags != null && !tags.isEmpty()) {
            if(!urlParameters.isEmpty()) {
                urlParameters += "&";
            }
            urlParameters += "tags=" + tags.replaceAll(",", "%2C");
        }
        if(!urlParameters.isEmpty()) {
            urlParameters = "?" + urlParameters;
        }
        requestURL.append(urlParameters);
        
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(requestURL.toString())
                .get()
                .addHeader(ApiConstants.RAPID_API_HOST_KEY, ApiConstants.RAPID_API_HOST_VALUE)
                .addHeader(ApiConstants.RAPID_API_KEY_KEY, ApiConstants.RAPID_API_KEY_VALUE)
                .build();
        
        Response requestResponse;
        RecipeResponse objectResponse = null;
        try {
            requestResponse = client.newCall(request).execute();
            if(requestResponse != null) {
                Gson gson = new Gson();
                objectResponse = gson.fromJson(requestResponse.body().string(), RecipeResponse.class);
            }
        }
        catch(IOException ex) {
            System.err.println("pt.iade.andre.cooking.testesandrecooking.provider.RecipesProvider."
                    + "getRandomRecipes:\nErro ao fazer request!");
            System.err.println(ex.getMessage() + ex);
        }
        
        if(objectResponse != null) {
            return objectResponse.getRecipes();
        }
        
        return null;
    }
}
