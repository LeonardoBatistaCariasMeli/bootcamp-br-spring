package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

public class DishResponse {
    private Integer id;
    private double price;
    private String description;
    private Integer quantity;

    public DishResponse(Integer id, double price, String description, Integer quantity) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
