package rw.ntaganira.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rw.ntaganira.orders.enums.OrderStatus;
import rw.ntaganira.shared.entity.BaseEntity;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.vendors.entity.Vendor;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : Order.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents marketplace customer orders
 * --------------------------------------------------------------------
 */

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(unique = true)
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private BigDecimal totalAmount;

    private String deliveryAddress;

    private String customerPhoneNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus =
            OrderStatus.PENDING;

    @Column(length = 10000)
    private String whatsappMessage;

}