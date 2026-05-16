package rw.ntaganira.users.dto;

import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : ChangePasswordRequest.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : DTO for changing user password
 * --------------------------------------------------------------------
 */

@Data
public class ChangePasswordRequest {

    private String currentPassword;

    private String newPassword;

}