package rw.ntaganira.wishlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.shared.entity.BaseEntity;
import rw.ntaganira.users.entity.User;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : WishlistItem.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents customer wishlist items
 * --------------------------------------------------------------------
 */

@Getter
@Setter
@Entity
@Table(name = "wishlist_items")
public class WishlistItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}