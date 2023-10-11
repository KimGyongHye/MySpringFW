package myspring.di.annot;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-beans-annot.xml")
public class AnnotatedHelloBeanTest {
	
	// 지금 이 영역에서 Hello인 타입은 하나밖에 없어서 변수명이랑 일치하지 않아도 가능
	@Autowired
	Hello hello;
	
	@Autowired
	HelloCons helloCons;
	
	@Resource(name = "stringPrinter")
	Printer printer;

	@Test
	void helloBean() {
		
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		
		assertSame(printer, hello.printer);
		assertEquals("Hello 어노테이션", printer.toString());
		
	}
	
	@Test
	void helloConBean() {
		assertEquals("Hello annot생성자", helloCons.sayHello());
		helloCons.print();
	}
	
}
