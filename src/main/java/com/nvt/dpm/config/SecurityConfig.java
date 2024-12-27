package com.nvt.dpm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nvt.dpm.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

	 private final UserDetailsServiceImpl userDetailsService;

	    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
	        this.userDetailsService = userDetailsService;
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable() // Tắt bảo vệ CSRF vì form đang gửi dữ liệu thô
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/register").permitAll() // Cho phép truy cập URL đăng ký
	                .requestMatchers("/admin/**").hasRole("ADMIN") // Chỉ Admin có quyền truy cập
	                .requestMatchers("/staff/**").hasRole("STAFF") // Chỉ Staff có quyền truy cập
	                .anyRequest().authenticated() // Các yêu cầu khác phải xác thực
	            )
	            .formLogin()
	                .loginPage("/") // Trang login tùy chỉnh (novotel.html)
	                .loginProcessingUrl("/login") // URL để xử lý form đăng nhập
	                .defaultSuccessUrl("/dashboard", true) // Điều hướng sau khi login thành công
	                .failureUrl("/?error=true") // Điều hướng khi login thất bại
	                .permitAll() // Mọi người đều có thể truy cập
	            .and()
	            .logout()
	                .logoutUrl("/logout") // URL để logout
	                .logoutSuccessUrl("/") // Điều hướng sau khi logout thành công
	                .permitAll();
	        return http.build();
	    }


	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
        return auth.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
