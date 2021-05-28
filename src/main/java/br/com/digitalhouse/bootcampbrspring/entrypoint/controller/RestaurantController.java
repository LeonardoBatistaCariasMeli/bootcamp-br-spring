package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.usecase.TableUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.OrderRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.CashBoxResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.TableResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    private TableUseCase tableUseCase;

    public RestaurantController(TableUseCase tableUseCase) {
        this.tableUseCase = tableUseCase;
    }

    @PostMapping("/tables")
    public ResponseEntity<Void> registerAnOrder(@RequestBody OrderRequest request) {
        this.tableUseCase.registerAnOrder(request);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/tables/{table_id}").buildAndExpand(request.getTableId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/tables/{table_id}")
    public ResponseEntity<TableResponse> getOrdersByTable(@PathVariable("table_id") Integer tableId) {
        var response = this.tableUseCase.getOrdersByTable(tableId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/tables/{table_id}")
    public ResponseEntity<Double> closeOrder(@PathVariable("table_id") Integer tableId) {
        Double totalPaymentValue = this.tableUseCase.closeOrder(tableId);

        return ResponseEntity.ok().body(totalPaymentValue);
    }

    @GetMapping("cashBox")
    public ResponseEntity<CashBoxResponse> getCashBoxMoney() {
        var response = this.tableUseCase.getMoneyCashBox();

        return ResponseEntity.ok().body(response);
    }
}
