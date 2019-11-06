package pt.iade.andre.cooking.testesandrecooking.model.utils;

import com.google.gson.annotations.SerializedName;

import pt.iade.andre.cooking.testesandrecooking.model.Recipe;

public class RecipeResponse {
    @SerializedName("recipes")
    private Recipe[] recipes;
    
    public RecipeResponse() {
        // EMPTY
    }

    public RecipeResponse(Recipe[] recipes) {
        this.recipes = recipes;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe[] recipes) {
        this.recipes = recipes;
    }
    
}
