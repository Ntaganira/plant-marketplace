package rw.ntaganira.products.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorProductRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for vendor product management
 * --------------------------------------------------------------------
 */

@Data
public class VendorProductRequest {

    private String name;

    private String description;

    private String shortDescription;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Integer stockQuantity;

    private Long categoryId;

    private String thumbnailUrl;

}