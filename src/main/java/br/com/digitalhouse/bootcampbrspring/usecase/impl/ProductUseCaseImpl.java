package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.ProductGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.ProductUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUseCaseImpl implements ProductUseCase {
    private final ProductGateway productGateway;

    public ProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product create(ProductRequest product) {
        return productGateway.create(product);
    }
}
