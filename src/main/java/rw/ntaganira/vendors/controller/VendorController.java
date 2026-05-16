package rw.ntaganira.vendors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ntaganira.shared.response.ApiResponse;
import rw.ntaganira.vendors.dto.VendorRequest;
import rw.ntaganira.vendors.dto.VendorResponse;
import rw.ntaganira.vendors.service.VendorService;

import java.util.List;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Exposes vendor management endpoints
 * --------------------------------------------------------------------
 */

@RestController
@RequestMapping("/api/v1/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @PostMapping
    public ResponseEntity<ApiResponse<VendorResponse>>
    createVendor(
            @RequestBody VendorRequest request
    ) {

        VendorResponse response =
                vendorService.createVendor(request);

        return ResponseEntity.ok(
                ApiResponse.<VendorResponse>builder()
                        .success(true)
                        .message("Vendor created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VendorResponse>>>
    getAllVendors() {

        return ResponseEntity.ok(
                ApiResponse.<List<VendorResponse>>builder()
                        .success(true)
                        .message("Vendors fetched successfully")
                        .data(
                                vendorService.getAllVendors()
                        )
                        .build()
        );
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ApiResponse<VendorResponse>>
    getVendor(
            @PathVariable String slug
    ) {

        return ResponseEntity.ok(
                ApiResponse.<VendorResponse>builder()
                        .success(true)
                        .message("Vendor fetched successfully")
                        .data(
                                vendorService.getVendorBySlug(
                                        slug
                                )
                        )
                        .build()
        );
    }

    @PutMapping("/{vendorId}/approve")
    public ResponseEntity<ApiResponse<VendorResponse>>
    approveVendor(
            @PathVariable Long vendorId
    ) {

        return ResponseEntity.ok(
                ApiResponse.<VendorResponse>builder()
                        .success(true)
                        .message("Vendor approved successfully")
                        .data(
                                vendorService.approveVendor(
                                        vendorId
                                )
                        )
                        .build()
        );
    }

}