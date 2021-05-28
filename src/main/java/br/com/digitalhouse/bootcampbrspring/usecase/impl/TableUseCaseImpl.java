package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Order;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Table;
import br.com.digitalhouse.bootcampbrspring.usecase.DishUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.TableUseCase;
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

@Service
public class TableUseCaseImpl implements TableUseCase {
    private static List<Table> tables = new ArrayList<>();
    private static Double cashBox = 0.0;

    private DishUseCase dishUseCase;

    public TableUseCaseImpl(DishUseCase dishUseCase) {
        this.dishUseCase = dishUseCase;
    }

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
            this.addInUsedTable(order, request.getTableId());
        } else {
            this.addNewTable(order);
        }
    }

    private Table addInUsedTable(Order order, Integer tableId) {
        for (Table t : this.tables) {
            if (t.getId() == tableId) {
                Integer lastIndex = getNextIndexOrderOf(t.getOrders());
                order.setId(lastIndex);
                t.addOrder(order);
                return t;
            }
        }
        return null;
    }

    private Table addNewTable(Order order) {
        order.setId(1);
        var listOrder = new ArrayList<Order>();
        listOrder.add(order);
        var table = new Table(order.getTableId(), listOrder, 0);
        this.tables.add(table);
        return table;
    }

    private Order assembleOrderOf(OrderRequest request) {
        var dishes = assembleListDishOf(request.getDishs());
        var totalValue = sumDishValues(dishes);
        return new Order(null, request.getTableId(), dishes, totalValue);
    }

    private List<Dish> assembleListDishOf(List<DishRequest> list) {
        return this.dishUseCase.getDishesOf(list);
    }

    private double sumDishValues(List<Dish> dishes) {
        return dishes.stream().map(d -> d.getPrice() * d.getQuantity()).reduce(0.0, Double::sum);
    }

    private Integer getNextIndexOrderOf(List<Order> orders) {
        Integer lastIndex = 0;
        for (Order o : orders) {
            if (o.getId() > lastIndex)
                lastIndex = o.getId() + 1;
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