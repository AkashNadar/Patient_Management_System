package com.idfc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import com.idfc.dao.UserRepository;
import com.idfc.model.User;
import com.idfc.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class UserServiceTests {
	
	@MockBean
	private UserRepository repo;
	
	@Autowired
	private UserService underTest;
	
	User user;
	User admin;

	@BeforeEach
	void setUp() throws Exception {
//		underTest = new UserServiceImpl(repo);
		
	}

//	@Test
//	void testCanAddUser() {
////		When
//		underTest.addUser(user);
//		
////		Then
//		ArgumentCaptor<User> argCapture = ArgumentCaptor.forClass(User.class);
////		capturing the values from the save method to test
//		verify(repo).save(argCapture.capture());
//		User capturedUser = argCapture.getValue();
//		assertThat(capturedUser).isEqualTo(user);
//		
//	}
//
//	@Test
//	void testGetUsers() {
////		When
//		underTest.getUsers();
////		Then
//		verify(repo).findAll();
//	}
//
//	@Test
//	void testGetUserById() {
////		Given
//		given(repo.findById(1)).willReturn(Optional.of(user));
////		When
//		User res = underTest.getUserById(user.getUserId()).get();
////		System.out.println(res);
////		Then
//		assertThat(res).isNotNull();
//	}
//
//	@Test
//	void testGetUserByEmail() {
////		Given
//		given(repo.findByEmail("Premkumar@gmail.com")).willReturn(user);
////		When
//		User resUser = underTest.getUserByEmail(user.getEmail());
////		Then
//		assertThat(resUser).isNotNull();
//	}
//
//	@Test
//	void testUpdatePasswordWithMathchingOldPassword() {
////		Given
//		given(repo.findByEmail("Premkumar@gmail.com")).willReturn(user);
////		When
//		underTest.updatePassword("Premkumar@gmail.com", "3333", "4444");
////		Then
//		ArgumentCaptor<User> argCapture = ArgumentCaptor.forClass(User.class);
//		verify(repo).save(argCapture.capture());
//		User capturedUser = argCapture.getValue();
//		assertThat(capturedUser.getPassword()).isEqualTo("4444");
//	}
//	
//	@Test
//	void testUpdatePasswordWithNotMathchingOldPassword() {
////		Given
//		given(repo.findByEmail("Premkumar@gmail.com")).willReturn(user);
////		When
//		User res = underTest.updatePassword("Premkumar@gmail.com", "2222", "4444");
////		Then
//		assertThat(res).isNull();
//	}
//
//	@Test
//	void testUpdateUserTypeIfItIsAdmin() {
////		Given
//		admin = new User(
//				2, 
//				"admin", 
//				"Male", 
//				"bandra", 
//				"Mumbai", 
//				"admin@gmail.com", 
//				6754890345l, 
//				null, 
//				null, 
//				"admin", 
//				"4444"
//		);
//		given(repo.findById(2)).willReturn(Optional.of(admin));
//		given(repo.findById(1)).willReturn(Optional.of(user));
////		When
//		underTest.updateUserType(2, 1);
////		Then
//		ArgumentCaptor<User> argCapture = ArgumentCaptor.forClass(User.class);
//		verify(repo).save(argCapture.capture());
//		User capturedUser = argCapture.getValue();
//		assertThat(capturedUser.getUserType()).isEqualTo("doctor");
//	}
//
//	@Test
//	void testUpdateUserTypeIfItIsNotAdmin() {
////		Given
//		admin = new User(
//				2, 
//				"admin", 
//				"Male", 
//				"bandra", 
//				"Mumbai", 
//				"admin@gmail.com", 
//				6754890345l, 
//				null, 
//				null, 
//				"doctor", 
//				"4444"
//		);
//		given(repo.findById(2)).willReturn(Optional.of(admin));
////		When
//		User res = underTest.updateUserType(2, 1);
////		Then
//		assertThat(res).isNull();
//	}
//	
//	@Test
//	@Disabled
//	void testUpdateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteUser() {
////		Given
//		willDoNothing().given(repo).deleteById(1);
//		given(repo.findById(1)).willReturn(Optional.of(user));
////		When
//		underTest.deleteUser(1);
////		Then
//		verify(repo, times(1)).deleteById(1);
//	}

}
