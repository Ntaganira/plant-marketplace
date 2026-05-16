package rw.ntaganira.users.dto;

import lombok.Builder;
import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : UserProfileResponse.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents authenticated user profile response
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class UserProfileResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String role;

    private String profilePhotoUrl;

}