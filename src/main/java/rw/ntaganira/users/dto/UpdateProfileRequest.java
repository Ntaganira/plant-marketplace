package rw.ntaganira.users.dto;

import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : UpdateProfileRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for updating user profile
 * --------------------------------------------------------------------
 */

@Data
public class UpdateProfileRequest {

    private String firstName;

    private String lastName;

    private String phoneNumber;

}