package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.usecase.ProductUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody  ProductRequest product){
        var response =  productUseCase.create(product);
        return ResponseEntity.created(URI.create("/")).build();

    }

}
