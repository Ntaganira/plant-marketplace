package rw.ntaganira.reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.reviews.entity.ProductReview;

import java.util.List;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductReviewRepository.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles product review database operations
 * --------------------------------------------------------------------
 */

public interface ProductReviewRepository
        extends JpaRepository<ProductReview, Long> {

    List<ProductReview> findByProduct(
            Product product
    );

    @Query("""
            SELECT COALESCE(AVG(r.rating), 0)
            FROM ProductReview r
            WHERE r.product = :product
            """)
    Double getAverageRating(
            Product product
    );

}