package rw.ntaganira.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rw.ntaganira.shared.exception.BadRequestException;
import rw.ntaganira.shared.exception.ResourceNotFoundException;
import rw.ntaganira.users.dto.ChangePasswordRequest;
import rw.ntaganira.users.dto.UpdateProfileRequest;
import rw.ntaganira.users.dto.UserProfileResponse;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.users.repository.UserRepository;
import rw.ntaganira.users.service.UserService;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * --------------------------------------------------------------------
 * Project : Rwanda Plant Marketplace
 * File : UserServiceImpl.java
 * Author : Heritier Ntaganira
 * Company : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description : Implements user management operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl
                implements UserService {

        private final UserRepository userRepository;

        private final PasswordEncoder passwordEncoder;

        @Override
        public UserProfileResponse getCurrentUser() {

                User user = getAuthenticatedUser();

                return mapToResponse(user);
        }

        @Override
        public UserProfileResponse updateProfile(
                        UpdateProfileRequest request) {

                User user = getAuthenticatedUser();

                user.setFirstName(
                                request.getFirstName());

                user.setLastName(
                                request.getLastName());

                user.setPhoneNumber(
                                request.getPhoneNumber());

                User updatedUser = userRepository.save(user);

                return mapToResponse(updatedUser);
        }

        @Override
        public void changePassword(
                        ChangePasswordRequest request) {

                User user = getAuthenticatedUser();

                boolean matches = passwordEncoder.matches(
                                request.getCurrentPassword(),
                                user.getPassword());

                if (!matches) {

                        throw new BadRequestException(
                                        "Current password is incorrect");
                }

                user.setPassword(
                                passwordEncoder.encode(
                                                request.getNewPassword()));

                userRepository.save(user);
        }

        private User getAuthenticatedUser() {

                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                return userRepository
                                .findByEmail(email)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "User not found"));
        }

        private UserProfileResponse mapToResponse(
                        User user) {

                return UserProfileResponse.builder()

                                .id(user.getId())

                                .firstName(user.getFirstName())

                                .lastName(user.getLastName())

                                .email(user.getEmail())

                                .phoneNumber(
                                                user.getPhoneNumber())

                                .role(user.getRole().name())

                                .profilePhotoUrl(
                                                user.getProfilePhotoUrl())

                                .build();
        }

}