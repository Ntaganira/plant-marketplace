package rw.ntaganira.products.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ntaganira.products.dto.ProductRequest;
import rw.ntaganira.products.dto.ProductResponse;
import rw.ntaganira.products.service.ProductService;
import rw.ntaganira.shared.response.ApiResponse;

import java.util.List;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Exposes product management endpoints
 * --------------------------------------------------------------------
 */

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>>
    createProduct(
            @RequestBody ProductRequest request
    ) {

        ProductResponse response =
                productService.createProduct(request);

        return ResponseEntity.ok(
                ApiResponse.<ProductResponse>builder()
                        .success(true)
                        .message("Product created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>>
    getProducts() {

        return ResponseEntity.ok(
                ApiResponse.<List<ProductResponse>>builder()
                        .success(true)
                        .message("Products fetched successfully")
                        .data(productService.getAllProducts())
                        .build()
        );
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ApiResponse<ProductResponse>>
    getProduct(
            @PathVariable String slug
    ) {

        return ResponseEntity.ok(
                ApiResponse.<ProductResponse>builder()
                        .success(true)
                        .message("Product fetched successfully")
                        .data(
                                productService.getProductBySlug(slug)
                        )
                        .build()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ProductResponse>>>
    searchProducts(
            @RequestParam String keyword
    ) {

        return ResponseEntity.ok(
                ApiResponse.<List<ProductResponse>>builder()
                        .success(true)
                        .message("Search completed successfully")
                        .data(
                                productService.searchProducts(
                                        keyword
                                )
                        )
                        .build()
        );
    }

}