package br.com.digitalhouse.bootcampbrspring.domain.gateways;

import java.util.List;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.ProductRequest;

public interface ProductGateway{
    Product create(ProductRequest request);
    Product findById(Long productId);
    List<Product> findAll();
}
