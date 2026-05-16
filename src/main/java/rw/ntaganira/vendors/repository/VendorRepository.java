package rw.ntaganira.vendors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.vendors.entity.Vendor;
import rw.ntaganira.vendors.enums.VendorStatus;

import java.util.Optional;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorRepository.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles vendor database operations
 * --------------------------------------------------------------------
 */

public interface VendorRepository
        extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findBySlug(String slug);

    Optional<Vendor> findByOwner(User owner);

    long countByVendorStatus(
        VendorStatus vendorStatus
    );

}