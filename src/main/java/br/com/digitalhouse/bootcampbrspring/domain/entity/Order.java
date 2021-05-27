package br.com.digitalhouse.bootcampbrspring.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private Integer tableId;
    private List<Dish> dishs = new ArrayList<>();
    private double totalValue;

    public Order(Integer id, Integer tableId, List<Dish> dishs, double totalValue) {
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

    public List<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
