package com.phoenix.pi.sales_platform.service;

import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.ProductDtoRequest;
import com.phoenix.pi.sales_platform.dto.UpdateProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto saveProduct(ProductDtoRequest productDto);
    ProductDto updateProduct(Long id, UpdateProductDto updateProductDto);
    void deleteProduct(Long id);

    Optional<ProductDto> getProductById(Long id);
}
