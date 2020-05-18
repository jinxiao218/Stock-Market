package com.ibm.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.ibm.model.User;
import com.ibm.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	 @Autowired
	MailService mailService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindOne() {
		User user =userService.findOne("admin1");
		Assert.notNull(user,"user can not be found");
		Assert.isTrue("admin1".equals(user.getUsername()),"username is not admin1");
		System.out.print(user);
		
	}

	@Test
	public void testIsConfirmed() {
		boolean isConfirmed = userService.isConfirmed("admin1");
		Assert.isTrue(isConfirmed,"admins is not confirmed");
	}

	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("admin1");
		user.setEmail("admin1@cn.ibm.com");
		user.setPassword("$2a$10$Y6NkOd9LCrCfdHXETceWQuwM7YlZtLpm64oPG3Xu1dLMxE2xg2Q5i");
		user.setCode("1234");
		user.setActive(true);
		user.setConfirmed(0);
		userService.register(user);
		System.out.println("email has been sent");
	}

	@Test
	public void testCheckCode() {
		User user =userService.findOne("0001");
		Assert.notNull(user,"0001 code for user can not be found");
	}

	@Test
	public void testUpdateUserStatus() {
		User user = new User();
		user.setUsername("admin1");
		user.setEmail("admin1@cn.ibm.com");
		user.setPassword("$2a$10$Y6NkOd9LCrCfdHXETceWQuwM7YlZtLpm64oPG3Xu1dLMxE2xg2Q5i");
		user.setCode("1234");
		user.setActive(true);
		user.setConfirmed(0);
		userService.updateUserStatus(user);
		System.out.println("User status has been updated");
	}

	@Test
	public void testLoginUser() {
		User user = new User();
		user.setUsername("admin1");
		user.setEmail("admin1@cn.ibm.com");
		user.setPassword("$2a$10$Y6NkOd9LCrCfdHXETceWQuwM7YlZtLpm64oPG3Xu1dLMxE2xg2Q5i");
		user.setCode("1234");
		user.setActive(true);
		user.setConfirmed(0);
		User user1 =userService.loginUser(user);
		Assert.notNull(user1,"user1 can not be login");
	}

}
