package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;

import java.util.List;

public class OrderRequest {
    private Integer tableId;
    private List<DishRequest> dishs;

    public OrderRequest(Integer tableId, List<DishRequest> dishs) {
        this.tableId = tableId;
        this.dishs = dishs;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public List<DishRequest> getDishs() {
        return dishs;
    }

    public void setDishs(List<DishRequest> dishs) {
        this.dishs = dishs;
    }
}

