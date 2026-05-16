package rw.ntaganira.vendors.service;

import rw.ntaganira.vendors.dto.VendorDashboardResponse;
import rw.ntaganira.vendors.dto.VendorRequest;
import rw.ntaganira.vendors.dto.VendorResponse;

import java.util.List;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorService.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles vendor business operations
 * --------------------------------------------------------------------
 */

public interface VendorService {

    VendorResponse createVendor(
            VendorRequest request
    );

    List<VendorResponse> getAllVendors();

    VendorResponse getVendorBySlug(
            String slug
    );

    VendorResponse approveVendor(
            Long vendorId
    );

    VendorDashboardResponse getDashboardStats();

}