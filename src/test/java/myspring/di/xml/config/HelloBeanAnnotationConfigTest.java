package myspring.di.xml.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.xml.Hello;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanAnnotationConfig.class, 
loader = AnnotationConfigContextLoader.class) // loader 생략해도 오류는 안 남
public class HelloBeanAnnotationConfigTest {
	
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
	}
}
