package com.phoenix.pi.sales_platform.service.impl;


import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.ProductDtoRequest;
import com.phoenix.pi.sales_platform.dto.UpdateProductDto;
import com.phoenix.pi.sales_platform.exception.ProductException;
import com.phoenix.pi.sales_platform.mappers.ProductMapper;
import com.phoenix.pi.sales_platform.model.entity.Product;
import com.phoenix.pi.sales_platform.repository.ProductRepository;
import com.phoenix.pi.sales_platform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(@Autowired(required=true) ProductRepository productRepository,@Autowired(required=true) ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto saveProduct(ProductDtoRequest productDto) {
        Product product = productMapper.toEntity(productDto);

        if (Objects.isNull(productDto)){
            throw new ProductException("It cannot be null");
        }
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long id, UpdateProductDto updateProductDto) {
        // Check if the product exists
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Product not found with ID: " + id));

        // Update the fields that are provided in UpdateProductDto
        if (updateProductDto.getDescription() != null) {
            existingProduct.setDescription(updateProductDto.getDescription());
        }
        if (updateProductDto.getBrand() != null) {
            existingProduct.setBrand(updateProductDto.getBrand());
        }
        if (updateProductDto.getCategory() != null) {
            existingProduct.setCategory(updateProductDto.getCategory());
        }
        if (updateProductDto.getQuantity() != null) {
            existingProduct.setQuantity(updateProductDto.getQuantity());
        }
        if (updateProductDto.getPrice() != null) {
            existingProduct.setPrice(updateProductDto.getPrice());
        }
        if (updateProductDto.getStatus() != null) {
            existingProduct.setStatus(updateProductDto.getStatus());
        }

        // Save the updated product
        Product updatedProduct = productRepository.save(existingProduct);

        // Return the updated product as a DTO
        return productMapper.toDto(updatedProduct);
    }


    @Override
    public void deleteProduct(Long id) {
        // Check if the product exists
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Product not found with ID: " + id));

        // Delete the product
        productRepository.delete(product);
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {

        // Check if the product exists
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Product not found with ID: " + id));

        return Optional.ofNullable(productMapper.toDto(existingProduct));
    }

}
