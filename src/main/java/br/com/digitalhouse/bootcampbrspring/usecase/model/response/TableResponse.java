package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import java.util.List;

public class TableResponse {
    private Integer id;
    private List<OrderResponse> orders;
    private double totalValue;

    public TableResponse(Integer id, List<OrderResponse> orders, double totalValue) {
        this.id = id;
        this.orders = orders;
        this.totalValue = totalValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderResponse> orders) {
        this.orders = orders;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
