package myspring.di.strategy2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.service.UserService;
import myspring.di.strategy2.dao.UserDao;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/service-beans-strategy2.xml")
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void serviceTest() {
		assertEquals(2, userService.getUserList().size());
	}
	
}
