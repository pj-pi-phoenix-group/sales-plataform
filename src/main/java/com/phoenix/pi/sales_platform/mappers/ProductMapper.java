package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.ProductDtoRequest;
import com.phoenix.pi.sales_platform.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(ProductDtoRequest productDto);
}
