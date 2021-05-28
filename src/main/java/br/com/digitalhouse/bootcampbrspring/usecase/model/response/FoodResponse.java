package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import java.util.List;

public class FoodResponse {
    private double totalCalories;
    private List<IngredientResponse> ingredientResponses;
    private String mostCaloricIngredient;

    public FoodResponse(double totalCalories, List<IngredientResponse> ingredientResponses, String mostCaloricIngredient) {
        this.totalCalories = totalCalories;
        this.ingredientResponses = ingredientResponses;
        this.mostCaloricIngredient = mostCaloricIngredient;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<IngredientResponse> getIngredientResponses() {
        return ingredientResponses;
    }

    public void setIngredientResponses(List<IngredientResponse> ingredientResponses) {
        this.ingredientResponses = ingredientResponses;
    }

    public String getMostCaloricIngredient() {
        return mostCaloricIngredient;
    }

    public void setMostCaloricIngredient(String mostCaloricIngredient) {
        this.mostCaloricIngredient = mostCaloricIngredient;
    }
}
