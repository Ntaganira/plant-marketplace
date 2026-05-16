package rw.ntaganira.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.wishlist.entity.WishlistItem;

import java.util.List;
import java.util.Optional;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : WishlistRepository.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles wishlist database operations
 * --------------------------------------------------------------------
 */

public interface WishlistRepository
        extends JpaRepository<WishlistItem, Long> {

    List<WishlistItem> findByUser(
            User user
    );

    Optional<WishlistItem> findByUserAndProduct(
            User user,
            Product product
    );

}