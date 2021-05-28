package br.com.digitalhouse.bootcampbrspring.usecase;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Order;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.OrderRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.CashBoxResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.OrderResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.TableResponse;

public interface TableUseCase {
    TableResponse getOrdersByTable(Integer tableId);
    void registerAnOrder(OrderRequest request);
    Double closeOrder(Integer tableId);
    CashBoxResponse getMoneyCashBox();
}
