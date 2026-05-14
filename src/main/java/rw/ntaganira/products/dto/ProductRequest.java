package rw.ntaganira.products.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for product creation requests
 * --------------------------------------------------------------------
 */

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    private String description;

    private String shortDescription;

    @NotNull
    private BigDecimal price;

    private BigDecimal discountPrice;

    private Integer stockQuantity;

    private Long categoryId;

}