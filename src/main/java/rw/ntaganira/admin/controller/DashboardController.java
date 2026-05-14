package rw.ntaganira.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : DashboardController.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles dashboard page routing
 * --------------------------------------------------------------------
 */

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {

        return "dashboard/index";
    }

}