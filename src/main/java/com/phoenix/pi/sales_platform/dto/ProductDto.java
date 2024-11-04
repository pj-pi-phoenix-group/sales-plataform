package com.phoenix.pi.sales_platform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonInclude
public class ProductDto {

    @Schema(description = "ID do Produto")
    private Long productId;

    @Schema(description = "Descrição do Produto")
    private String description;

    @Schema(description = "Marca do Produto")
    private String brand;

    @Schema(description = "Categoria do Produto")
    private String category;

    @Schema(description = "Quantidade em estoque")
    private int quantity;

    @Schema(description = "Preço do Produto")
    private double price;

    @Schema(description = "Status do Produto")
    private StatusEnum status;

}
