package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

public class DishRequest {
    private Integer dishId;
    private Integer quantity;

    public DishRequest(Integer dishId, Integer quantity) {
        this.dishId = dishId;
        this.quantity = quantity;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
