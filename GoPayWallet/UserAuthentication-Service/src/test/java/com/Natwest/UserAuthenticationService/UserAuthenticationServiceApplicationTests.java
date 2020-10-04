package com.Natwest.UserAuthenticationService;


import com.Natwest.UserAuthenticationService.model.User;
import com.Natwest.UserAuthenticationService.repository.UserAuthenticationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


public class UserAuthenticationServiceApplicationTests {

	@Autowired
	private UserAuthenticationRepository autheticationRepository;

	private User user;


	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setUserName("Jhon123");
		user.setUserPassword("pass123");
		user.setUserLocation("India");
		user.setEmail("aj@gmail.com");
		user.setContact("1234567890");
		user.setUserAddedDate(new Date());
	}

	@After
	public void tearDown() throws Exception {
		autheticationRepository.deleteAll();
	}

	@Test
	public void testRegisterUserSuccess() {
		autheticationRepository.save(user);
		User object = autheticationRepository.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword());
		Assert.assertEquals(user.getUserId(), object.getUserId());
	}

	@Test
	public void testLoginUserSuccess() {
		autheticationRepository.save(user);
		User object = autheticationRepository.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword());
		Assert.assertEquals(user.getUserId(), object.getUserId());
	}
}
