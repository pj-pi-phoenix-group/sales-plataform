package com.phoenix.pi.sales_platform.controller;


import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.ProductDtoRequest;
import com.phoenix.pi.sales_platform.dto.UpdateProductDto;
import com.phoenix.pi.sales_platform.model.entity.Product;
import com.phoenix.pi.sales_platform.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1/product")
@Tag(name = "Product API", description = "Endpoints for managing products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Retrieve a product by its ID")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        Optional<ProductDto> product = service.getProductById(id);

        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Create a new product by providing its details")
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDtoRequest product) {
        ProductDto createdProduct = service.saveProduct(product);

        if(!Objects.nonNull(product)){
            return ResponseEntity.unprocessableEntity().build();
        }
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    @Operation(summary = "Update an existing product"
            , description = "Update product details by providing the product ID and updated information")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Long id
            , @RequestBody UpdateProductDto updateProductDto){
        ProductDto updatedProduct = service.updateProduct(id, updateProductDto);

        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Delete an existing product by its ID")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
