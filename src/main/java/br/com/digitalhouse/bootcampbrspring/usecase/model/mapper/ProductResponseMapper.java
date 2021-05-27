package br.com.digitalhouse.bootcampbrspring.usecase.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.ProductResponse;

public interface ProductResponseMapper {

	public static List<ProductResponse> fromProducts(List<Product> products) {
		return products.stream().map(ProductResponseMapper::fromProduct).collect(Collectors.toList());
	}
	
	public static ProductResponse fromProduct(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}
	
}
