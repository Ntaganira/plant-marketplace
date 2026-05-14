package rw.ntaganira.vendors.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : VendorRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for vendor registration requests
 * --------------------------------------------------------------------
 */

@Data
public class VendorRequest {

    @NotBlank
    private String businessName;

    private String description;

    private String phoneNumber;

    private String emailAddress;

    private String address;

    private String city;

    private String whatsappNumber;

    private String logoUrl;

    private String bannerUrl;

}