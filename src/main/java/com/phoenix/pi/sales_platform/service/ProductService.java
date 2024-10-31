package com.phoenix.pi.sales_platform.service;

import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.UpdateProductDto;

import java.util.List;

public interface ProductService {

    void deleteProduct();

    List<ProductDto> getAllProducts();

    ProductDto saveProduct(ProductDto product);

    ProductDto updateProduct(Long id, UpdateProductDto updateProductDto);
}
