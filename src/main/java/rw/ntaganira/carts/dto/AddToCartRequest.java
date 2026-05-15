package rw.ntaganira.carts.dto;

import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : AddToCartRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for adding products to cart
 * --------------------------------------------------------------------
 */

@Data
public class AddToCartRequest {

    private Long productId;

    private Integer quantity;

}