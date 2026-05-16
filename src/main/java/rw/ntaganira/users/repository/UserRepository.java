package rw.ntaganira.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ntaganira.users.entity.User;
import rw.ntaganira.users.enums.UserRole;

import java.util.Optional;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : UserRepository.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles database operations for users
 * --------------------------------------------------------------------
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    long countByRole(
        UserRole role
    );
}