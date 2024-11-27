package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.ProductDto;
import com.phoenix.pi.sales_platform.dto.ProductDtoRequest;
import com.phoenix.pi.sales_platform.model.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T18:11:32-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

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

        product.setDescription( productDto.getDescription() );
        product.setBrand( productDto.getBrand() );
        product.setCategory( productDto.getCategory() );
        product.setQuantity( productDto.getQuantity() );
        product.setPrice( productDto.getPrice() );
        product.setStatus( productDto.getStatus() );

        return product;
    }
}
