package com.idfc.service;

import java.util.List;
import java.util.Optional;

import com.idfc.model.User;


public interface UserService {
	
	public String hello();

	public User addUser(User user);
	
	public List<User> getUsers();
	
	public Optional<User> getUserById(long id);
	
	public User getUserByEmail(String email);
	
	public User updatePassword(String email, String oldPassword, String newPassword);
	
	public User updateUserType(long userId, long userIdToUpdate);
	
	public String deleteUser(long id);
}
