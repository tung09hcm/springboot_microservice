package com.ryo.microservice.productservice.service;

import com.ryo.microservice.productservice.dto.request.ProductRequest;
import com.ryo.microservice.productservice.dto.response.ProductResponse;
import com.ryo.microservice.productservice.model.Product;
import com.ryo.microservice.productservice.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductService {
    ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
        productRepository.save(product);
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(
                    x -> new ProductResponse(x.getId(), x.getName(), x.getDescription(), x.getPrice())
        ).toList();
    }
}
