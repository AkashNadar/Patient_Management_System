package com.idfc.controller;

import java.util.List;
import java.util.Map;

import com.idfc.model.User;
import com.idfc.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		User resUser = this.service.addUser(user);
		if(resUser == null) {
			return new ResponseEntity<Object>("User not add Sucessfully", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllUsers(){
		List<User> users = this.service.getUsers();
		return new ResponseEntity<Object>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUserById(@PathVariable int userId){
		User resUser = this.service.getUserById(userId).get();
		if(resUser == null) {
			return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.OK);
	}
	
	@GetMapping("/email")
	public ResponseEntity<Object> getUserByEmail(@RequestParam String email){
		User res = service.getUserByEmail(email);
		if(res == null) {
			return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	@PatchMapping("/updatePassword")
	public ResponseEntity<Object> updatePassword(@RequestBody Map<String, Object> body){
		User resUser = this.service.updatePassword(
				body.get("email").toString(), 
				body.get("oldPassword").toString(), 
				body.get("newPassword").toString());
		
		if(resUser == null) {
			return new ResponseEntity<Object>("password updation failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Object>("password updated sucessfully", HttpStatus.OK);
	}
	
	@PatchMapping("/updateUserType/{adminId}/{userId}")
	public ResponseEntity<Object> updateUserType(@PathVariable int adminId, @PathVariable int userId){
		User res = this.service.updateUserType(adminId, userId);
		if(res == null) {
			return new ResponseEntity<Object>("User type not updated sucessfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>("Role updated sucessfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Object> removeUser(@PathVariable int userId){
		String res = this.service.deleteUser(userId);
		if(res == null) {
			return new ResponseEntity<Object>("user not deleted !", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
}
