package rw.ntaganira.reviews.dto;

import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ReviewRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for product review submissions
 * --------------------------------------------------------------------
 */

@Data
public class ReviewRequest {

    private Long productId;

    private String review;

    private Integer rating;

}