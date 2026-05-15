package rw.ntaganira.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rw.ntaganira.products.entity.Product;
import rw.ntaganira.shared.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : OrderItem.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents products inside orders
 * --------------------------------------------------------------------
 */

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

}