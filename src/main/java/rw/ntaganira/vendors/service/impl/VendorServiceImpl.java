package rw.ntaganira.vendors.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ntaganira.shared.exception.ResourceNotFoundException;
import rw.ntaganira.vendors.dto.VendorRequest;
import rw.ntaganira.vendors.dto.VendorResponse;
import rw.ntaganira.vendors.entity.Vendor;
import rw.ntaganira.vendors.enums.VendorStatus;
import rw.ntaganira.vendors.repository.VendorRepository;
import rw.ntaganira.vendors.service.VendorService;

import java.util.List;
import java.util.UUID;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorServiceImpl.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Implements vendor business operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class VendorServiceImpl
        implements VendorService {

    private final VendorRepository vendorRepository;

    @Override
    public VendorResponse createVendor(
            VendorRequest request
    ) {

        Vendor vendor = new Vendor();

        vendor.setBusinessName(
                request.getBusinessName()
        );

        vendor.setSlug(
                request.getBusinessName()
                        .toLowerCase()
                        .replace(" ", "-")
                        + "-"
                        + UUID.randomUUID()
                        .toString()
                        .substring(0, 5)
        );

        vendor.setDescription(
                request.getDescription()
        );

        vendor.setPhoneNumber(
                request.getPhoneNumber()
        );

        vendor.setEmailAddress(
                request.getEmailAddress()
        );

        vendor.setAddress(
                request.getAddress()
        );

        vendor.setCity(
                request.getCity()
        );

        vendor.setWhatsappNumber(
                request.getWhatsappNumber()
        );

        vendor.setLogoUrl(
                request.getLogoUrl()
        );

        vendor.setBannerUrl(
                request.getBannerUrl()
        );

        Vendor savedVendor =
                vendorRepository.save(vendor);

        return mapToResponse(savedVendor);
    }

    @Override
    public List<VendorResponse> getAllVendors() {

        return vendorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public VendorResponse getVendorBySlug(
            String slug
    ) {

        Vendor vendor = vendorRepository
                .findBySlug(slug)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vendor not found"
                        ));

        return mapToResponse(vendor);
    }

    @Override
    public VendorResponse approveVendor(
            Long vendorId
    ) {

        Vendor vendor = vendorRepository
                .findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vendor not found"
                        ));

        vendor.setVendorStatus(
                VendorStatus.APPROVED
        );

        return mapToResponse(
                vendorRepository.save(vendor)
        );
    }

    private VendorResponse mapToResponse(
            Vendor vendor
    ) {

        return VendorResponse.builder()
                .id(vendor.getId())
                .businessName(
                        vendor.getBusinessName()
                )
                .slug(vendor.getSlug())
                .description(
                        vendor.getDescription()
                )
                .phoneNumber(
                        vendor.getPhoneNumber()
                )
                .emailAddress(
                        vendor.getEmailAddress()
                )
                .city(vendor.getCity())
                .country(vendor.getCountry())
                .logoUrl(vendor.getLogoUrl())
                .bannerUrl(vendor.getBannerUrl())
                .whatsappNumber(
                        vendor.getWhatsappNumber()
                )
                .vendorStatus(
                        vendor.getVendorStatus().name()
                )
                .build();
    }

}