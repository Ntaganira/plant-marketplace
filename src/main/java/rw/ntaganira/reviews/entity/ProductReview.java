package rw.ntaganira.reviews.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.shared.entity.BaseEntity;
import rw.ntaganira.users.entity.User;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ProductReview.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents product customer reviews
 * --------------------------------------------------------------------
 */

@Getter
@Setter
@Entity
@Table(name = "product_reviews")
public class ProductReview extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 3000)
    private String review;

    private Integer rating;

}