package com.phoenix.pi.sales_platform.service;

import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.model.Product;

import java.util.List;

public interface ProductService {

    void deleteProduct();

    List<ProductDto> getAllProducts();

    ProductDto saveProduct(ProductDto product);
}
