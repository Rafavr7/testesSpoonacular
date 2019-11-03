/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.iade.andre.cooking.testesandrecooking.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author rv_ra
 */
public class Recipe {
    @SerializedName("id")
    private int recipeId;
    
    @SerializedName("title")
    private String recipeTitle;
    
    @SerializedName("preparationMinutes")
    private int preparationMinutes;
    
    @SerializedName("cookingMinutes")
    private int cookingMinutes;
    
    @SerializedName("readyInMinutes")
    private int readyInMinutes;
    
    @SerializedName("instructions")
    private String instructions;
    
    @SerializedName("vegetarian")
    private boolean isVegetarian;
    
    @SerializedName("vegan")
    private boolean isVegan;
    
    @SerializedName("glutenFree")
    private boolean isGlutenFree;
    
    @SerializedName("dairyFree")
    private boolean isDairyFree;
    
    @SerializedName("veryHealthy")
    private boolean isVeryHealthy;
    

    public Recipe() {
        
    }

    public Recipe(int recipeId, String recipeTitle, int preparationMinutes, int cookingMinutes,
            int readyInMinutes, String instructions, boolean isVegetarian, boolean isVegan,
            boolean isGlutenFree, boolean isDairyFree, boolean isVeryHealthy) {
        
        this.recipeId = recipeId;
        this.recipeTitle = recipeTitle;
        this.preparationMinutes = preparationMinutes;
        this.cookingMinutes = cookingMinutes;
        this.readyInMinutes = readyInMinutes;
        this.instructions = instructions;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isDairyFree = isDairyFree;
        this.isVeryHealthy = isVeryHealthy;
    }
    
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public int getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(int preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(int cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public boolean isIsVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public boolean isIsGlutenFree() {
        return isGlutenFree;
    }

    public void setIsGlutenFree(boolean isGlutenFree) {
        this.isGlutenFree = isGlutenFree;
    }

    public boolean isIsDairyFree() {
        return isDairyFree;
    }

    public void setIsDairyFree(boolean isDairyFree) {
        this.isDairyFree = isDairyFree;
    }

    public boolean isIsVeryHealthy() {
        return isVeryHealthy;
    }

    public void setIsVeryHealthy(boolean isVeryHealthy) {
        this.isVeryHealthy = isVeryHealthy;
    }
}
