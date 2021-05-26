package br.com.digitalhouse.bootcampbrspring.dataprovider;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.ProductData;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Product;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.ProductGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.DataIntegrityException;
import br.com.digitalhouse.bootcampbrspring.usecase.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDataProvider implements ProductGateway {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(ProductRequest request) {
        if(request.getPrice() < 200){
            throw new DataIntegrityException("price cannot be less than 200");
        }
        var productData = new ProductData(null,request.getDescription(),request.getName(),request.getPrice());
        productData  = productRepository.save(productData);
        return toProductOf(productData);
    }

    private Product toProductOf(ProductData productData){
        return new Product(productData.getName(),productData.getDescription(), productData.getPrice());
    }
}
