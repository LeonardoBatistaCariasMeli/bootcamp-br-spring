package br.com.digitalhouse.bootcampbrspring.usecase.model.mapper;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Order;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Table;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.DishResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.OrderResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.TableResponse;

import java.util.List;
import java.util.stream.Collectors;

public interface TableResponseMapper {

    public static TableResponse fromTable(Table table) {
        return new TableResponse(table.getId(), fromListOrder(table.getOrders()), table.getTotalValue());
    }

    public static List<OrderResponse> fromListOrder(List<Order> orders) {
        return orders.stream().map(TableResponseMapper::fromOrder).collect(Collectors.toList());
    }
    public static OrderResponse fromOrder(Order order) {
        return new OrderResponse(order.getId(), order.getTableId(), fromListDish(order.getDishs()), order.getTotalValue());
    }

    public static List<DishResponse> fromListDish(List<Dish> dishs) {
        return dishs.stream().map(TableResponseMapper::fromDish).collect(Collectors.toList());
    }
    public static DishResponse fromDish(Dish dish) {
        return new DishResponse(dish.getId(), dish.getPrice(), dish.getDescription(), dish.getQuantity());
    }
}
