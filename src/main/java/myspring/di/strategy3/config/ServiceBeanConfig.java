package myspring.di.strategy3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.dao.UserDaoImpl;
import myspring.di.strategy1.service.UserService;
import myspring.di.strategy1.service.UserServiceImpl;

@Configuration
public class ServiceBeanConfig {

	@Bean
	UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	UserService userService() {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserdao(userDao());
		return userService;
	}
}
