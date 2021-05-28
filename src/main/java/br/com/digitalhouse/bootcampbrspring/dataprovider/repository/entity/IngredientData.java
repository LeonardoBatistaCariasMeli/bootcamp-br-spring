package br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity;

public class IngredientData {
    private String name;
    private double calories;

    public IngredientData(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public IngredientData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
