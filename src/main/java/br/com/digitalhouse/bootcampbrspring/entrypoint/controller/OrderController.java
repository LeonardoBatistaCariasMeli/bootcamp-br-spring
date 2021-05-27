package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Order;
import br.com.digitalhouse.bootcampbrspring.usecase.OrderUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.OrderRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.CashBoxResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.OrderResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.TableResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderUseCase orderUseCase;

    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    @PostMapping("/tables")
    public ResponseEntity<Void> registerAnOrder(@RequestBody OrderRequest request) {
        this.orderUseCase.registerAnOrder(request);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/tables/{table_id}").buildAndExpand(request.getTableId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/tables/{table_id}")
    public ResponseEntity<TableResponse> getOrdersByTable(@PathVariable("table_id") Integer tableId) {
        var response = this.orderUseCase.getOrdersByTable(tableId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/tables/{table_id}")
    public ResponseEntity<Double> closeOrder(@PathVariable("table_id") Integer tableId) {
        Double totalPaymentValue = this.orderUseCase.closeOrder(tableId);

        return ResponseEntity.ok().body(totalPaymentValue);
    }

    @GetMapping("cashBox")
    public ResponseEntity<CashBoxResponse> getCashBoxMoney() {
        var response = this.orderUseCase.getMoneyCashBox();

        return ResponseEntity.ok().body(response);
    }
}
