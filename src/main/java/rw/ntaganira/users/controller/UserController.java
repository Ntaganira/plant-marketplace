package rw.ntaganira.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ntaganira.shared.response.ApiResponse;
import rw.ntaganira.users.dto.ChangePasswordRequest;
import rw.ntaganira.users.dto.UpdateProfileRequest;
import rw.ntaganira.users.dto.UserProfileResponse;
import rw.ntaganira.users.service.UserService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : UserController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Exposes user profile management endpoints
 * --------------------------------------------------------------------
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserProfileResponse>>
    getCurrentUser() {

        return ResponseEntity.ok(
                ApiResponse.<UserProfileResponse>builder()
                        .success(true)
                        .message("User profile fetched successfully")
                        .data(
                                userService.getCurrentUser()
                        )
                        .build()
        );
    }

    @PutMapping("/profile")
    public ResponseEntity<ApiResponse<UserProfileResponse>>
    updateProfile(
            @RequestBody
            UpdateProfileRequest request
    ) {

        return ResponseEntity.ok(
                ApiResponse.<UserProfileResponse>builder()
                        .success(true)
                        .message("Profile updated successfully")
                        .data(
                                userService.updateProfile(
                                        request
                                )
                        )
                        .build()
        );
    }

    @PutMapping("/change-password")
    public ResponseEntity<ApiResponse<String>>
    changePassword(
            @RequestBody
            ChangePasswordRequest request
    ) {

        userService.changePassword(request);

        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .success(true)
                        .message("Password changed successfully")
                        .data("SUCCESS")
                        .build()
        );
    }

}