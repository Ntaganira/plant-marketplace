package rw.ntaganira.users.service;

import rw.ntaganira.users.dto.ChangePasswordRequest;
import rw.ntaganira.users.dto.UpdateProfileRequest;
import rw.ntaganira.users.dto.UserProfileResponse;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : UserService.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles user management operations
 * --------------------------------------------------------------------
 */

public interface UserService {

    UserProfileResponse getCurrentUser();

    UserProfileResponse updateProfile(
            UpdateProfileRequest request
    );

    void changePassword(
            ChangePasswordRequest request
    );

}