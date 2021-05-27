package br.com.digitalhouse.bootcampbrspring.domain.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;

public interface ProductMapper {
	
	public static List<Product> fromProductDataList(List<ProductData> productsData) {
		return productsData.stream().map(ProductMapper::fromProductData).collect(Collectors.toList());
	}
	
	public static Product fromProductData(ProductData data) {
		return new Product(data.getId(), data.getName(), data.getDescription(), data.getPrice());
	}
}
