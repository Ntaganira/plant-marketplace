package rw.ntaganira.vendors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rw.ntaganira.products.dto.VendorProductRequest;
import rw.ntaganira.products.service.ProductService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorProductController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles vendor product management pages
 * --------------------------------------------------------------------
 */

@Controller
@RequestMapping("/vendor/products")
@RequiredArgsConstructor
public class VendorProductController {

    private final ProductService productService;

    @GetMapping
    public String products(
            Model model
    ) {

        model.addAttribute(
                "products",
                productService.getVendorProducts()
        );

        return "vendor/products/list";
    }

    @GetMapping("/create")
    public String createPage(
            Model model
    ) {

        model.addAttribute(
                "product",
                new VendorProductRequest()
        );

        return "vendor/products/create";
    }

    @PostMapping("/create")
    public String createProduct(
            @ModelAttribute
            VendorProductRequest request
    ) {

        productService.createVendorProduct(
                request
        );

        return "redirect:/vendor/products";
    }

}