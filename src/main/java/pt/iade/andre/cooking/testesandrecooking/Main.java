package pt.iade.andre.cooking.testesandrecooking;

import pt.iade.andre.cooking.testesandrecooking.exceptions.BadRequestException;
import pt.iade.andre.cooking.testesandrecooking.model.Recipe;
import pt.iade.andre.cooking.testesandrecooking.provider.RecipesProvider;

/**
 *
 * @author Rafael Vieira Rangel
 */
public class Main {
    
    public static void main(String[] args) {
        /**
        try {
        Ingredient[] ingredients = IngedientsProvider.getIngredientSuggestions("appl", 3, true, null);
        if(ingredients != null) {
        System.out.println("Ingredients Array Size: " + ingredients.length);
        for(Ingredient ing : ingredients) {
        System.out.println(ing);
        }
        }
        }
        catch (BadRequestException ex) {
        System.err.println(ex.getMessage() + ex);
        }
         */
        
        Recipe[] recipes = RecipesProvider.getRandomRecipes(5, false, null);
        if(recipes != null) {
            System.out.println("Recipes Array Size: " + recipes.length);
            for(Recipe rcp : recipes) {
                System.out.println("Recipe Title: " + rcp.getRecipeTitle());
                System.out.println("Recipe Cooking Time: " + rcp.getCookingMinutes());
                System.out.println("Gluten free: " + rcp.isIsGlutenFree() + "\n");
            }
        }
        
        System.out.println("\nEND");
    }
    
}
