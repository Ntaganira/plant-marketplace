package rw.ntaganira.admin.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : DashboardStatsResponse.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents marketplace dashboard statistics
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class DashboardStatsResponse {

    private Long totalProducts;

    private Long totalVendors;

    private Long totalOrders;

    private Long totalCustomers;

    private Long pendingVendors;

    private BigDecimal totalRevenue;

}