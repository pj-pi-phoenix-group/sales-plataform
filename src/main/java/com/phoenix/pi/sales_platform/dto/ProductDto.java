package com.phoenix.pi.sales_platform.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDto {

    private Long productId;
    private String name;
    private int quantity;
    private double price;
}
