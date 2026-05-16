package rw.ntaganira.admin.service;

import rw.ntaganira.admin.dto.DashboardStatsResponse;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : AdminDashboardService.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles admin dashboard operations
 * --------------------------------------------------------------------
 */

public interface AdminDashboardService {

    DashboardStatsResponse getDashboardStats();

}