/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.iade.andre.cooking.testesandrecooking;

import java.util.List;
import pt.iade.andre.cooking.testesandrecooking.model.Recipe;
import pt.iade.andre.cooking.testesandrecooking.provider.SpoonacularAPI2;

/**
 *
 * @author rv_ra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        List<Recipe> apiResponse = SpoonacularAPI2.getRandomRecipe();
        
        /*if(apiResponse != null) {
            System.out.println("Recipe title: " + apiResponse.getRecipeTitle());
            System.out.println("Recipe preparation time: " + apiResponse.getPreparationMinutes());
            System.out.println("Recipe cooking time: " + apiResponse.getCookingMinutes());
        }
        else {
            System.err.println("Retornou null!");
        }*/
        
        if(apiResponse != null) {
            System.out.println("List size: " + apiResponse.size());
            for(Recipe rcp : apiResponse) {
                System.out.println("Recipe title: " + rcp.getRecipeTitle());
                System.out.println("Recipe preparation time: " + rcp.getPreparationMinutes());
                System.out.println("Recipe cooking time: " + rcp.getCookingMinutes());
            }
        }
        else {
            System.err.println("Resposta 'null'");
        }
    }
    
}
