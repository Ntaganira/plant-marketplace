package rw.ntaganira.products.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rw.ntaganira.categories.entity.Category;
import rw.ntaganira.shared.entity.BaseEntity;
import rw.ntaganira.users.entity.User;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : Product.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents marketplace products
 * --------------------------------------------------------------------
 */

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String slug;

    @Column(length = 5000)
    private String description;

    private String shortDescription;

    @Column(nullable = false)
    private BigDecimal price;

    private BigDecimal discountPrice;

    private Integer stockQuantity = 0;

    @Column(unique = true)
    private String sku;

    private Boolean featured = false;

    private String thumbnailUrl;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private User vendor;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}