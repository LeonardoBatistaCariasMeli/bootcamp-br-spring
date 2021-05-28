package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

public class IngredientResponse {
    private String name;
    private double totalCalories;

    public IngredientResponse(String name, double totalCalories) {
        this.name = name;
        this.totalCalories = totalCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
