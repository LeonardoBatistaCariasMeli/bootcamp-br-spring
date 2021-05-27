package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import java.util.List;

public class OrderResponse {
    private Integer id;
    private Integer tableId;
    private List<DishResponse> dishs;
    private double totalValue;

    public OrderResponse() {
    }

    public OrderResponse(Integer id, Integer tableId, List<DishResponse> dishs, double totalValue) {
        this.id = id;
        this.tableId = tableId;
        this.dishs = dishs;
        this.totalValue = totalValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public List<DishResponse> getDishs() {
        return dishs;
    }

    public void setDishs(List<DishResponse> dishs) {
        this.dishs = dishs;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
