package br.com.digitalhouse.bootcampbrspring.usecase.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ProductRequest {
    @Length(min = 5,max = 100,message = "very big name")
    @NotEmpty(message = "qualquer mensagem")
    private String name;
    private String description;
    private double price;

    public ProductRequest() {
    }

    public ProductRequest(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
