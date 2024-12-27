package com.nvt.dpm.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nvt.dpm.entity.Users;
import com.nvt.dpm.repository.StaffRepository;
import com.nvt.dpm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
    private StaffRepository staffRepository;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	 @Override
	    public Users registerUser(Users user) {
	        // Kiểm tra username đã tồn tại
	        if (userRepository.findByUsername(user.getUsername()) != null) {
	            throw new RuntimeException("Username đã tồn tại: " + user.getUsername());
	        }

	        // Kiểm tra số điện thoại đã được sử dụng hay chưa
	        if (isPhoneRegistered(user.getStaff().getPhone())) {
	            throw new RuntimeException("Số điện thoại này đã được sử dụng để đăng ký!");
	        }

	        // Mã hóa mật khẩu
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }

    @Override
    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isStaffRegistered(int staffId) {
        return userRepository.findAll().stream()
                .anyMatch(user -> user.getStaff() != null && user.getStaff().getId() == staffId);
    }

    @Override
    public boolean isPhoneRegistered(String phoneNumber) {
        return staffRepository.findByPhone(phoneNumber) != null;
    }
	

}
