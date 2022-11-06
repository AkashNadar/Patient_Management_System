package com.idfc.service;

import java.util.List;
import java.util.Optional;

import com.idfc.dao.UserRepository;
import com.idfc.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	public UserServiceImpl(UserRepository repo) {
		super();
		this.repo = repo;
	}

	public UserServiceImpl() {
		super();
		//TODO Auto-generated constructor stub
	}

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
	public Optional<User> getUserById(int id) {
		return this.repo.findById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public User updatePassword(String email, String oldPassword, String newPassword) {
//		User resUser = this.getUserById(userId).isPresent() 
//				? this.getUserById(userId).get()
//				: null;
		User resUser = repo.findByEmail(email);
		if(resUser == null || !resUser.getPassword().equals(oldPassword)) {
			return null;
		}
		resUser.setPassword(newPassword);
		return this.repo.save(resUser);
	}
	
	@Override
	public User updateUserType(int userId, int userIdToUpdate) {
		Optional<User> adminUser = repo.findById(userId);
		if(adminUser.get() == null || !adminUser.get().getUserType().equals("admin")) {
			return null;
		}
		Optional<User> updateUser = repo.findById(userIdToUpdate);
		if(updateUser.get() == null) {
			return null;
		}
		
		if(updateUser.get().getUserType().equals("patient")) {
			updateUser.get().setUserType("doctor");
		}
		else {
			updateUser.get().setUserType("patient");
		}
		
		return this.repo.save(updateUser.get());
	}

	@Override
	public User updateUser(User user) {
		User updateUser = this.getUserById(user.getUserId()).get();
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
		Optional<User> resUser = repo.findById(id);
		if(resUser.get() == null) {
			return null;
		}
		this.repo.deleteById(id);
		return "User deleted sucessfully";
	}

	

	
}
