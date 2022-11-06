package com.idfc.dao;

import com.idfc.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
}
