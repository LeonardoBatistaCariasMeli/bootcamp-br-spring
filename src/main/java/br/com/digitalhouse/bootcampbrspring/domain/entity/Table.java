package br.com.digitalhouse.bootcampbrspring.domain.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private Integer id;
    private List<Order> orders = new ArrayList<>();
    private double totalValue;

    public Table(Integer id, List<Order> orders, double totalValue) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public void addOrder(Order order) {
        this.orders.addAll(Arrays.asList(order));
    }
}
