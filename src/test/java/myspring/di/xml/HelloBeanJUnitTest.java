package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJUnitTest {

	BeanFactory factory;

	// 사전에 공통으로 해야하는 것들이 있으면 BeforeEach
	@BeforeEach
	void init() {
		// 1. 컨테이너 객체를 생성해줘야 함
		// new GenericXmlApplicationContext(String ...resourceLocations)
		// String ...은 안에 매개변수 갯수가 정해지지 않은 것
		// 실행하자마자(= 컨테이너를 만들자 마자) 객체가 생성이 됨
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
		// Bean 컨테이너
		// 호출이 되는 순간 빈들이 생성 됨!!!!!!!!!!!!!!!!!!!!
	}
	

	// test case를 만들때 꼭 void로 메소드를 만들어야함
	// 꼭 어노테이션 붙히기
	// @Disabled를 쓰면 실행이 안 됨
	@Test @Disabled
	void helloSetter(){

		Hello hello1 = (Hello)factory.getBean("myHello");
		Hello hello2 = factory.getBean("myHello", Hello.class);
		//Hello hello3 = factory.getBean("hello", Hello.class);

		// 둘이 완전히 같니?
		// Assertions 검증하는 것
		// static import >> static의 특정 메소드만 import가 가능
		// Assertions.assertSame(hello1, hello2);

		// import static org.junit.jupiter.api.Assertions.assertSame;
		// 위에 import가 되었기 때문에 메소드만 가져올 수 있음
		//assertSame(hello1, hello2);
		//assertSame(hello1, hello3);
		// assertEquals("Hello  스프링", hello1.sayHello());
		assertEquals("Hello 스프링", hello2.sayHello()); 
		hello1.print();
		// 틀릴 때 org.opebtest4j.AssertionFaildeError를 더블클릭하면 빨간색이 뜬 이유가 뜸


		// 다형성!!
		Printer printer1 = (Printer)factory.getBean("strPrinter");
		Printer printer2 = hello1.printer;

		assertSame(printer1, printer2);

		//assertEquals("Hello 스프링", printer1.toString());
		// assertEquals("Hello 스프링", printer2.toString());

		// assertEquals("Hello 스프링", printer1.toString());

	}

	@Test @Disabled
	void helloConstructTest() {

		Hello helloCon = factory.getBean("myHelloCon", Hello.class);
		assertEquals("Hello 생성자", helloCon.sayHello());
		
	}

	@Test @Disabled
	void helloSetCollection() {

		Hello helloCol = factory.getBean("myHelloCollection", Hello.class);
		
		List<String> names = helloCol.getNames();
		assertEquals("Spring", names.get(0));
		assertEquals("SpringBoot", names.get(1));
		assertEquals("SpringCloud", names.get(2));
		assertEquals(3, helloCol.getNames().size());
		
	}
	
}
