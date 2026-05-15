package rw.ntaganira.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rw.ntaganira.products.service.ProductService;
import rw.ntaganira.vendors.service.VendorService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : HomeController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles marketplace homepage routes
 * --------------------------------------------------------------------
 */

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    private final VendorService vendorService;

    @GetMapping("/")
    public String home(
            Model model
    ) {

        model.addAttribute(
                "products",
                productService.getAllProducts()
        );

        model.addAttribute(
                "vendors",
                vendorService.getAllVendors()
        );

        return "home/index";
    }

}