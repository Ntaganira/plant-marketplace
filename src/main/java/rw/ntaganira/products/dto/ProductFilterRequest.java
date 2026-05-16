package rw.ntaganira.products.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductFilterRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents product filtering request
 * --------------------------------------------------------------------
 */

@Data
public class ProductFilterRequest {

    private String keyword;

    private Long categoryId;

    private Double minPrice;

    private Double maxPrice;

    private String sortBy = "createdAt";

    private Sort.Direction direction =
            Sort.Direction.DESC;

    private Integer page = 0;

    private Integer size = 12;

}