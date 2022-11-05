package com.idfc.service;

import java.util.List;

import com.idfc.dao.UserRepository;
import com.idfc.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public User addUser(User user) {
		User resEmail = this.getUserByEmail(user.getEmail());
		if(resEmail != null) {
			return null;
		}
		return this.repo.save(user);
	}

	@Override
	public List<User> getUsers() {
		return this.repo.findAll();
	}

	@Override
	public User getUserById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public User getUserByEmail(String email) {
		List<User> users = this.repo.findAll();
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User updatePassword(int userId, String oldPassword, String newPassword) {
		User resUser = this.getUserById(userId);
		if(resUser == null || !resUser.getPassword().equals(oldPassword)) {
			return null;
		}
		resUser.setPassword(newPassword);
		return this.repo.save(resUser);
	}
	
	@Override
	public User updateUserType(int userId, int userIdToUpdate) {
		User adminUser = this.getUserById(userId);
		if(adminUser == null || !adminUser.getUserType().equals("admin")) {
			return null;
		}
		User updateUser = this.getUserById(userIdToUpdate);
		if(updateUser == null) {
			return null;
		}
		
		if(updateUser.getUserType().equals("patient")) {
			updateUser.setUserType("doctor");
		}
		else {
			updateUser.setUserType("patient");
		}
		
		return this.repo.save(updateUser);
	}

	@Override
	public User updateUser(User user) {
		User updateUser = this.getUserById(user.getUserId());
		updateUser.setAddress(user.getAddress());
		updateUser.setCity(user.getCity());
		updateUser.setDept(user.getDept());
		updateUser.setEducation(user.getDept());
		updateUser.setName(user.getName());
		updateUser.setPhno(user.getPhno());
		return null;
	}

	@Override
	public String deleteUser(int id) {
		User resUser = this.getUserById(id);
		if(resUser == null) {
			return null;
		}
		this.repo.deleteById(id);
		return "User deleted sucessfully";
	}

	

	
}
