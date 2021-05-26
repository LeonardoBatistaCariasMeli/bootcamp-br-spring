package br.com.digitalhouse.bootcampbrspring.domain.gateways;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.usecase.model.ProductRequest;

public interface ProductGateway{
    Product create(ProductRequest request);
}
