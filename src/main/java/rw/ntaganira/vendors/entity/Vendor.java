package rw.ntaganira.vendors.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rw.ntaganira.shared.entity.BaseEntity;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.vendors.enums.VendorStatus;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : Vendor.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents marketplace vendors
 * --------------------------------------------------------------------
 */

@Getter
@Setter
@Entity
@Table(name = "vendors")
public class Vendor extends BaseEntity {

    @Column(nullable = false)
    private String businessName;

    @Column(unique = true)
    private String slug;

    @Column(length = 5000)
    private String description;

    private String phoneNumber;

    private String emailAddress;

    private String address;

    private String city;

    private String country = "Rwanda";

    private String logoUrl;

    private String bannerUrl;

    private String whatsappNumber;

    @Enumerated(EnumType.STRING)
    private VendorStatus vendorStatus =
            VendorStatus.PENDING;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User owner;

}