package com.idfc;

import static org.junit.jupiter.api.Assertions.*;

import com.idfc.controller.UserController;
import com.idfc.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService service;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHello() {
		fail("Not yet implemented");
	}

	@Test
	void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserByEmail() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePassword() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUserType() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveUser() {
		fail("Not yet implemented");
	}

}
