package rw.ntaganira.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.ntaganira.orders.entity.Order;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : OrderRepository.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles order database operations
 * --------------------------------------------------------------------
 */

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    @Query("""
            SELECT COALESCE(SUM(o.totalAmount), 0)
            FROM Order o
            """)
    BigDecimal getTotalRevenue();

}