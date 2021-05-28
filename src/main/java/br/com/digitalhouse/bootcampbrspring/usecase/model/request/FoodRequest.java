package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

import java.util.List;

public class FoodRequest {
    private String name;
    private List<IngredientRequest> ingredients;

    public FoodRequest(String name, List<IngredientRequest> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientRequest> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientRequest> ingredients) {
        this.ingredients = ingredients;
    }
}
