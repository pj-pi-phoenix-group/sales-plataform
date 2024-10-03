package com.phoenix.pi.sales_platform.service.impl;


import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.mappers.ProductMapper;
import com.phoenix.pi.sales_platform.model.Product;
import com.phoenix.pi.sales_platform.repository.ProductRepository;
import com.phoenix.pi.sales_platform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void deleteProduct() {
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
}
