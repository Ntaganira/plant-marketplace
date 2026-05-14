package rw.ntaganira.categories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ntaganira.categories.entity.Category;

import java.util.Optional;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : CategoryRepository.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles category database operations
 * --------------------------------------------------------------------
 */

public interface CategoryRepository
        extends JpaRepository<Category, Long> {

    Optional<Category> findBySlug(String slug);

}