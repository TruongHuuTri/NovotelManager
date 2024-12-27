package com.nvt.dpm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.nvt.dpm.entity.Users;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        Users user = (Users) authentication.getPrincipal();
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("role", user.getRole());

        String role = authentication.getAuthorities().iterator().next().getAuthority();
        if ("ROLE_ADMIN".equals(role)) {
            return "users/admin"; // Trả về admin.html
        } else if ("ROLE_STAFF".equals(role)) {
            return "users/staff"; // Trả về staff.html
        }
        return "redirect:/";
    }
}
