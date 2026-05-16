package rw.ntaganira.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ntaganira.admin.dto.DashboardStatsResponse;
import rw.ntaganira.admin.service.AdminDashboardService;
import rw.ntaganira.orders.repository.OrderRepository;
import rw.ntaganira.products.repository.ProductRepository;
import rw.ntaganira.users.enums.UserRole;
import rw.ntaganira.users.repository.UserRepository;
import rw.ntaganira.vendors.enums.VendorStatus;
import rw.ntaganira.vendors.repository.VendorRepository;

import java.math.BigDecimal;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : AdminDashboardServiceImpl.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Implements admin dashboard statistics operations
 * --------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl
        implements AdminDashboardService {

    private final ProductRepository productRepository;

    private final VendorRepository vendorRepository;

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    @Override
    public DashboardStatsResponse getDashboardStats() {

        BigDecimal revenue =
                orderRepository.getTotalRevenue();

        return DashboardStatsResponse.builder()

                .totalProducts(
                        productRepository.count()
                )

                .totalVendors(
                        vendorRepository.count()
                )

                .totalOrders(
                        orderRepository.count()
                )

                .totalCustomers(
                        userRepository.countByRole(
                                UserRole.CUSTOMER
                        )
                )

                .pendingVendors(
                        vendorRepository.countByVendorStatus(
                                VendorStatus.PENDING
                        )
                )

                .totalRevenue(
                        revenue != null
                                ? revenue
                                : BigDecimal.ZERO
                )

                .build();
    }

}