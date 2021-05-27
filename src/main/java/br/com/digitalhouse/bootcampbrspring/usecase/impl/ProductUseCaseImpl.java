package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.digitalhouse.bootcampbrspring.domain.gateways.ProductGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.ProductUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.mapper.ProductResponseMapper;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.ProductRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.ProductResponse;

@Service
public class ProductUseCaseImpl implements ProductUseCase {
    private ProductGateway productGateway;

    public ProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductResponse create(ProductRequest product) {
    	var prod = productGateway.create(product);
    	
        return ProductResponseMapper.fromProduct(prod);
    }

    @Override
	public ProductResponse findById(Long productId) {
		var product = this.productGateway.findById(productId);
		
		return ProductResponseMapper.fromProduct(product);
	}
    
	@Override
	public List<ProductResponse> findAll() {
		var products = this.productGateway.findAll();
		
		return ProductResponseMapper.fromProducts(products);
	}

}
