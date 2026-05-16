package rw.ntaganira.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rw.ntaganira.admin.service.AdminDashboardService;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : AdminDashboardController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles admin dashboard pages
 * --------------------------------------------------------------------
 */

@Controller
@RequiredArgsConstructor
public class AdminDashboardController {

    private final AdminDashboardService
            adminDashboardService;

    @GetMapping("/admin/dashboard")
    public String dashboard(
            Model model
    ) {

        model.addAttribute(
                "stats",
                adminDashboardService.getDashboardStats()
        );

        return "admin/dashboard";
    }

}