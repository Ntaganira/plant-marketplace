package rw.ntaganira.vendors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rw.ntaganira.vendors.service.VendorService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorStorefrontController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles vendor storefront pages
 * --------------------------------------------------------------------
 */

@Controller
@RequiredArgsConstructor
public class VendorStorefrontController {

    private final VendorService vendorService;

    @GetMapping("/vendors/{slug}")
    public String storefront(
            @PathVariable String slug,
            Model model
    ) {

        model.addAttribute(
                "vendor",
                vendorService.getVendorBySlug(slug)
        );

        return "vendors/storefront";
    }

}