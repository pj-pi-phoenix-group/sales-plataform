package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.ProductDtoRequest;
import com.phoenix.pi.sales_platform.model.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T10:07:20-0300",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if ( product.getUserId() != null ) {
            productDto.setUserId( product.getUserId() );
        }
        productDto.setProductId( product.getProductId() );
        productDto.setDescription( product.getDescription() );
        productDto.setBrand( product.getBrand() );
        productDto.setCategory( product.getCategory() );
        productDto.setQuantity( product.getQuantity() );
        productDto.setPrice( product.getPrice() );
        productDto.setStatus( product.getStatus() );

        return productDto;
    }

    @Override
    public Product toEntity(ProductDtoRequest productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setUserId( productDto.getUserId() );
        product.setDescription( productDto.getDescription() );
        product.setBrand( productDto.getBrand() );
        product.setCategory( productDto.getCategory() );
        product.setQuantity( productDto.getQuantity() );
        product.setPrice( productDto.getPrice() );
        product.setStatus( productDto.getStatus() );

        return product;
    }
}
