package rw.ntaganira.products.service;

import rw.ntaganira.products.dto.ProductRequest;
import rw.ntaganira.products.dto.ProductResponse;
import rw.ntaganira.products.dto.VendorProductRequest;

import java.util.List;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : ProductService.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Handles product business operations
 * --------------------------------------------------------------------
 */

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductBySlug(String slug);

    List<ProductResponse> searchProducts(String keyword);

    List<ProductResponse> getVendorProducts();

    ProductResponse createVendorProduct(
            VendorProductRequest request);

    ProductResponse updateVendorProduct(
            Long productId,
            VendorProductRequest request);

    void deleteVendorProduct(
            Long productId);

}