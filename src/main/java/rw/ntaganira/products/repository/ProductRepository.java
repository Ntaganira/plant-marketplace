package rw.ntaganira.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.users.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : ProductRepository.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Handles product database operations
 * --------------------------------------------------------------------
 */

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    Optional<Product> findBySlug(String slug);

    List<Product> findByFeaturedTrue();

    List<Product> findByNameContainingIgnoreCase(String keyword);

    long count();

    long countByVendor(User vendor);

    long countByVendorAndStockQuantityLessThan(
            User vendor,
            Integer stockQuantity);

    List<Product> findByVendor(User vendor);

    Page<Product> findByNameContainingIgnoreCase(
            String keyword,
            Pageable pageable);
}