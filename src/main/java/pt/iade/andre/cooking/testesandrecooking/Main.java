package pt.iade.andre.cooking.testesandrecooking;

import pt.iade.andre.cooking.testesandrecooking.exceptions.BadRequestException;
import pt.iade.andre.cooking.testesandrecooking.model.Ingredient;
import pt.iade.andre.cooking.testesandrecooking.provider.IngedientsProvider;

/**
 *
 * @author Rafael Vieira Rangel
 */
public class Main {
    
    public static void main(String[] args) {
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
    }
    
}
