package rw.ntaganira.products.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import rw.ntaganira.products.dto.ProductFilterRequest;
import rw.ntaganira.products.dto.ProductResponse;
import rw.ntaganira.products.service.ProductService;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : ProductViewController.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Handles product storefront pages
 * --------------------------------------------------------------------
 */

@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductService productService;

    @GetMapping("/products/{slug}")
    public String productDetails(
            @PathVariable String slug,
            Model model) {

        model.addAttribute(
                "product",
                productService.getProductBySlug(slug));

        return "products/details";
    }

    @GetMapping("/products/search")
    public String searchProducts(
            @RequestParam String keyword,
            Model model) {

        model.addAttribute(
                "products",
                productService.searchProducts(keyword));

        return "products/list";
    }

    @GetMapping("/marketplace")
    public String marketplace(
            @ModelAttribute ProductFilterRequest request,
            Model model) {

        Page<ProductResponse> products = productService.searchProducts(
                request);

        model.addAttribute(
                "products",
                products);

        model.addAttribute(
                "request",
                request);

        return "products/marketplace";
    }
}