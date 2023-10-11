package myspring.di.strategy3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.service.UserService;
import myspring.di.strategy2.dao.UserDao;
import myspring.di.strategy3.config.ServiceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServiceConfig.class)
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
