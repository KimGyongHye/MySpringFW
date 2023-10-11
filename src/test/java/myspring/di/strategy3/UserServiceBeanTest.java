package myspring.di.strategy3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;
import myspring.di.strategy3.config.ServiceBeanConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServiceBeanConfig.class)
public class UserServiceBeanTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void serviceTest() {
		assertEquals(2, userService.getUserList().size());
	}
	
}
