package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-beans-user.xml")
public class UserDBTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	public void dbTest() {
		try {
			
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getDatabaseProductName());
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
			System.out.println(metaData.getDriverName());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sqlSessionFactoryTest() {
		System.out.println(sqlSessionFactory.getClass().getName());
	}
	
	@Test @Disabled
	void sqlSessionTemplate() {
		UserVO userVO = sqlSession.selectOne("myspring.user.dao.mapper.UserMapper.selectUserById","dooly");
		// 글자가 하나라도 대소문자도 틀리면 안됨 >> 타입 세이프하지 않음
		System.out.println(userVO);
	}
	
	@Test @Disabled
	void userMapperTest() {
		// 불러올 수 있는게 타입 세이프한거
		UserVO userVO = userMapper.selectUserById("dooly");
		System.out.println(userVO);

	}
	
	@Test
	void userServiceTest() {
		UserVO userVO = userService.getUser("dooly");
		System.out.println(userVO);
	}
	
}
