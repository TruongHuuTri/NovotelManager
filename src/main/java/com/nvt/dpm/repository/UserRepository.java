package com.nvt.dpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nvt.dpm.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
}
