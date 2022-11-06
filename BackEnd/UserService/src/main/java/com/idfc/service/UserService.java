package com.idfc.service;

import java.util.List;
import java.util.Optional;

import com.idfc.model.User;


public interface UserService {

	public User addUser(User user);
	
	public List<User> getUsers();
	
	public Optional<User> getUserById(int id);
	
	public User getUserByEmail(String email);
	
	public User updatePassword(String email, String oldPassword, String newPassword);
	
	public User updateUser(User user);
	
	public User updateUserType(int userId, int userIdToUpdate);
	
	public String deleteUser(int id);
}
