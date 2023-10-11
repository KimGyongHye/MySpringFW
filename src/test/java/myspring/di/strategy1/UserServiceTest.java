package myspring.di.strategy1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;


public class UserServiceTest {

	BeanFactory factory;
	
	@BeforeEach
	void conn() {
		factory = new GenericXmlApplicationContext("classpath:service-beans-strategy1.xml");
	}
	
	@Test
	public void serviceTest() {
		UserDao userDao = factory.getBean("userDaoImpl",UserDao.class);
		UserService userService = factory.getBean("userServiceImpl",UserService.class);
		
		assertEquals(2, userService.getUserList().size());
	}
}
