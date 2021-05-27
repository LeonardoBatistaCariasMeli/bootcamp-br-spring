package br.com.digitalhouse.bootcampbrspring.usecase;

import java.util.List;

import br.com.digitalhouse.bootcampbrspring.usecase.model.request.ProductRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.ProductResponse;

public interface ProductUseCase {
    ProductResponse create(ProductRequest product);
    ProductResponse findById(Long productId);
    List<ProductResponse> findAll();
}
