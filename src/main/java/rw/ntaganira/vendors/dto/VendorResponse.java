package rw.ntaganira.vendors.dto;

import lombok.Builder;
import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorResponse.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for vendor response data
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class VendorResponse {

    private Long id;

    private String businessName;

    private String slug;

    private String description;

    private String phoneNumber;

    private String emailAddress;

    private String city;

    private String country;

    private String logoUrl;

    private String bannerUrl;

    private String whatsappNumber;

    private String vendorStatus;

}