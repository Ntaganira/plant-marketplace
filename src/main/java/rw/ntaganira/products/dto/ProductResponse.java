package rw.ntaganira.products.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductResponse.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for returning product details
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class ProductResponse {

    private Long id;

    private String name;

    private String slug;

    private String description;

    private String shortDescription;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Integer stockQuantity;

    private String thumbnailUrl;

    private String category;

    private String vendor;

}