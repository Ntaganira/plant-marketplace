package rw.ntaganira.wishlist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rw.ntaganira.wishlist.service.WishlistService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : WishlistController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles wishlist operations
 * --------------------------------------------------------------------
 */

@Controller
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/{productId}")
    public String addToWishlist(
            @PathVariable Long productId
    ) {

        wishlistService.addToWishlist(
                productId
        );

        return "redirect:/";
    }

    @PostMapping("/{productId}/remove")
    public String removeFromWishlist(
            @PathVariable Long productId
    ) {

        wishlistService.removeFromWishlist(
                productId
        );

        return "redirect:/";
    }

}