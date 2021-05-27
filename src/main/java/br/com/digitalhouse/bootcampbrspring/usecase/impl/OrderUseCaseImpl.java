package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Order;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Table;
import br.com.digitalhouse.bootcampbrspring.domain.entity.mapper.DishMapper;
import br.com.digitalhouse.bootcampbrspring.usecase.OrderUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.DataIntegrityException;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.bootcampbrspring.usecase.model.mapper.TableResponseMapper;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.DishRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.OrderRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.CashBoxResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.TableResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderUseCaseImpl implements OrderUseCase {
    private static List<Table> tables = new ArrayList<>();
    private static Double cashBox = 0.0;
    @Override
    public TableResponse getOrdersByTable(Integer tableId) {
        if (this.isSomeoneUsingTable(tableId)) {
            return TableResponseMapper.fromTable(getTableOf(tableId));
        }
        throw new DataIntegrityException("This table has no customers!");
    }

    private boolean isSomeoneUsingTable(Integer tableId) {
        return tables.stream().anyMatch(t -> t.getId().equals(tableId));
    }

    private Table getTableOf(Integer tableId) {
        for (Table t : this.tables) {
            if (t.getId() == tableId) {
                double total = t.getOrders().stream().map(Order::getTotalValue).reduce(0.0, Double::sum);
                t.setTotalValue(total);
                return t;
            }
        }
        throw new ObjectNotFoundException("This table not exists!");
    }

    @Override
    public void registerAnOrder(OrderRequest request) {
        var order = assembleOrderOf(request);
        if (this.isSomeoneUsingTable(request.getTableId())) {
            for (Table t : this.tables) {
                if (t.getId() == request.getTableId()) {
                    Integer lastIndex = getNextIndexOrderOf(t.getOrders());
                    order.setId(lastIndex);
                    t.addOrder(order);
                }
            }
        } else {
            this.addNewTable(order);
        }
    }

    private void addNewTable(Order order) {
        order.setId(1);
        var listOrder = new ArrayList<Order>();
        listOrder.add(order);
        var table = new Table(order.getTableId(), listOrder, 0);
        this.tables.add(table);
    }

    private Order assembleOrderOf(OrderRequest request) {
        var totalValue = sumDishValues(request.getDishs());
        return new Order(null, request.getTableId(), assembleListDishOf(request.getDishs()), totalValue);
    }

    private List<Dish> assembleListDishOf(List<DishRequest> list) {
        return list.stream().map(DishMapper::assembleDishOf).collect(Collectors.toList());
    }

    private double sumDishValues(List<DishRequest> dishs) {
        return dishs.stream().map(d -> d.getPrice() * d.getQuantity()).reduce(0.0, Double::sum);
    }

    private Integer getNextIndexOrderOf(List<Order> orders) {
        Integer lastIndex = 1;
        for (Order o : orders) {
            if (o.getId() > lastIndex)
                lastIndex = o.getId();
        }
        return lastIndex;
    }

    @Override
    public Double closeOrder(Integer tableId) {
        var table = getTableOf(tableId);
        var totalValuePayment = table.getTotalValue();
        this.tables.remove(table);

        this.cashBox += table.getTotalValue();

        return totalValuePayment;
    }

    @Override
    public CashBoxResponse getMoneyCashBox() {
        return new CashBoxResponse(this.cashBox);
    }
}