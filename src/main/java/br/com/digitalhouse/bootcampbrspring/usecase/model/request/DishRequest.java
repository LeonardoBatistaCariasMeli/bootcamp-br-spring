package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

public class DishRequest {
    private double price;
    private String description;
    private Integer quantity;

    public DishRequest(double price, String description, Integer quantity) {
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
