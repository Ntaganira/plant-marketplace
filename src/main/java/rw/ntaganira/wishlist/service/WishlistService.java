package rw.ntaganira.wishlist.service;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : WishlistService.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles wishlist operations
 * --------------------------------------------------------------------
 */

public interface WishlistService {

    void addToWishlist(
            Long productId
    );

    void removeFromWishlist(
            Long productId
    );

}