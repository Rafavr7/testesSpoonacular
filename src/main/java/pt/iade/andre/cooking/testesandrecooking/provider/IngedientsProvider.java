package pt.iade.andre.cooking.testesandrecooking.provider;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import pt.iade.andre.cooking.testesandrecooking.exceptions.BadRequestException;
import pt.iade.andre.cooking.testesandrecooking.model.Ingredient;
import pt.iade.andre.cooking.testesandrecooking.utils.ApiConstants;


public class IngedientsProvider {
    
    /**
     * Class Constants
     */
    private static final String PROVIDER_BASE_URL = ApiConstants.RAPID_API_BASE_URL + "/food/ingredients";
    
    /**
     * 
     * @param query
     * @param number
     * @param metaInformation
     * @param intolerances
     * @return
     * @throws BadRequestException 
     */
    public static Ingredient[] getIngredientSuggestions(String query, Integer number,
            Boolean metaInformation, String intolerances) throws BadRequestException {
        
        if(query == null || query.isEmpty()) {
            throw new BadRequestException("O parâmetro 'query' não pode ser nem 'null' nem uma String vazia!");
        }
        
        StringBuilder requestURL = new StringBuilder();
        requestURL.append(PROVIDER_BASE_URL).append("/autocomplete?");
        
        if(number != null && number > 0) {
            requestURL.append("number=").append(number).append("&");
        }
        if(metaInformation != null) {
            requestURL.append("metaInformation=").append(metaInformation).append("&");
        }
        if(intolerances != null && !intolerances.isEmpty()) {
            requestURL.append("intolerances=").append(intolerances).append("&");
        }
        requestURL.append("query=").append(query);
        
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(requestURL.toString())
                .get()
                .addHeader(ApiConstants.RAPID_API_HOST_KEY, ApiConstants.RAPID_API_HOST_VALUE)
                .addHeader(ApiConstants.RAPID_API_KEY_KEY, ApiConstants.RAPID_API_KEY_VALUE)
                .build();
        
        Response requestResponse;
        Ingredient[] objectResponse = null;
        try {
            requestResponse = client.newCall(request).execute();
            if(requestResponse != null) {
                Gson gson = new Gson();
                objectResponse = gson.fromJson(requestResponse.body().string(), Ingredient[].class);
            }
        }
        catch(IOException ex) {
            System.err.println("pt.iade.andre.cooking.testesandrecooking.provider.IngredientsProvider."
                    + "getIngredientSuggestions:\nErro ao fazer request!");
            System.err.println(ex.getMessage() + ex);
        }
        
        return objectResponse;
    }
}
