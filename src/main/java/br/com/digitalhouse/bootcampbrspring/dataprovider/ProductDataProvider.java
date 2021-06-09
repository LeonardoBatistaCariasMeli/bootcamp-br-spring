package br.com.digitalhouse.bootcampbrspring.dataprovider;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.domain.entity.mapper.ProductMapper;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.ProductGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.DataIntegrityException;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.ProductRequest;

@Service
public class ProductDataProvider implements ProductGateway {

	private ProductRepository productRepository;
	
    public ProductDataProvider(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
    public Product create(ProductRequest request) {
        if(request.getPrice() < 200){
            throw new DataIntegrityException("price cannot be less than 200");
        }
        var productData = new ProductData(null,request.getDescription(),request.getName(),request.getPrice());
        productData  = productRepository.save(productData);

        return ProductMapper.fromProductData(productData);
    }

	@Override
	public Product findById(Long productId) {
		var data = this.productRepository.findById(productId);
		
		validatesIfProudctExists(data);
		
		return ProductMapper.fromProductData(data.get());
	}

	@Override
	public List<Product> findAll() {
		var products = this.productRepository.findAll();
		return ProductMapper.fromProductDataList(products);
	}
	
		private void validatesIfProudctExists(Optional<ProductData> data) {
		if(!data.isPresent())
			throw new ObjectNotFoundException("There are no products to the specifications");
	}

}
