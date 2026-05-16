package rw.ntaganira.vendors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rw.ntaganira.vendors.service.VendorService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorDashboardController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles vendor dashboard pages
 * --------------------------------------------------------------------
 */

@Controller
@RequiredArgsConstructor
public class VendorDashboardController {

    private final VendorService vendorService;

    @GetMapping("/vendor/dashboard")
    public String dashboard(
            Model model
    ) {

        model.addAttribute(
                "stats",
                vendorService.getDashboardStats()
        );

        return "vendor/dashboard";
    }

}