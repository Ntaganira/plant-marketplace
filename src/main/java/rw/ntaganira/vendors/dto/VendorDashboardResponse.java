package rw.ntaganira.vendors.dto;

import lombok.Builder;
import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorDashboardResponse.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents vendor dashboard analytics
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class VendorDashboardResponse {

    private Long totalProducts;

    private Long totalOrders;

    private Long lowStockProducts;

    private Long totalInventory;

}