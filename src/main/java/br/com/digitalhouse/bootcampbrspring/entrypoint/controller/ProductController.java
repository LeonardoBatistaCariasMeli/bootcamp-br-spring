package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digitalhouse.bootcampbrspring.configuration.response.SuccessResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.ProductUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.ProductRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.ProductResponse;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductRequest product){
        var response = this.productUseCase.create(product);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{product_id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product_id") Long productId) {
    	var response = this.productUseCase.findById(productId);
    	return ResponseEntity.ok().body(response);
    }
    
    @GetMapping
    public ResponseEntity<SuccessResponse<List<ProductResponse>>> getAllProducts() {
    	var response = this.productUseCase.findAll();
    	
    	return ResponseEntity.ok().body(new SuccessResponse<List<ProductResponse>>(response));
    }

}
