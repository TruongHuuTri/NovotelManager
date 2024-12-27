package com.nvt.dpm.controller;

import com.nvt.dpm.entity.Users;
import com.nvt.dpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/verify-phone")
    public ResponseEntity<?> verifyPhone(@RequestParam String phoneNumber) {
        boolean isRegistered = userService.isPhoneRegistered(phoneNumber);
        return ResponseEntity.ok(isRegistered ? "Số điện thoại đã được đăng ký!" : "Số điện thoại chưa được đăng ký.");
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        try {
            Users registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // API đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("Đăng nhập thành công!");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Đăng nhập thất bại: " + e.getMessage());
        }
    }
}
