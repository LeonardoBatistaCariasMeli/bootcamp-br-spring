package br.com.digitalhouse.bootcampbrspring.usecase;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.usecase.model.ProductRequest;

public interface ProductUseCase {
    Product create(ProductRequest product);
}
