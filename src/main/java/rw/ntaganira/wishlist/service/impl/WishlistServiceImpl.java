package rw.ntaganira.wishlist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.products.repository.ProductRepository;
import rw.ntaganira.shared.exception.ResourceNotFoundException;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.users.repository.UserRepository;
import rw.ntaganira.wishlist.entity.WishlistItem;
import rw.ntaganira.wishlist.repository.WishlistRepository;
import rw.ntaganira.wishlist.service.WishlistService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : WishlistServiceImpl.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Implements wishlist business operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl
        implements WishlistService {

    private final WishlistRepository wishlistRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Override
    public void addToWishlist(
            Long productId
    ) {

        User user = getAuthenticatedUser();

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"
                        ));

        boolean exists =
                wishlistRepository
                        .findByUserAndProduct(
                                user,
                                product
                        )
                        .isPresent();

        if (!exists) {

            WishlistItem item =
                    new WishlistItem();

            item.setUser(user);

            item.setProduct(product);

            wishlistRepository.save(item);
        }
    }

    @Override
    public void removeFromWishlist(
            Long productId
    ) {

        User user = getAuthenticatedUser();

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"
                        ));

        wishlistRepository
                .findByUserAndProduct(
                        user,
                        product
                )
                .ifPresent(wishlistRepository::delete);
    }

    private User getAuthenticatedUser() {

        String email =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        ));
    }

}