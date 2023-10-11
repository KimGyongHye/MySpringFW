
package myspring.di.xml;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// JUnit 프레임워크 테스트 실행방법을 확잘할 때 사용하는 어노테이션
// SpringExtension클래스를 지정해 주면 jUnit 이 테스트를 진행하는 중에 ApplicationContext 를 만들고 관리하는 작업을 진행해
@ExtendWith(SpringExtension.class)
// 설정 파일의 위치를 지정할 때 사용되는 어노테이션
@ContextConfiguration(locations = "classpath:spring-beans.xml")
// 위의 어노테이션 두개가 factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");랑 같은 것
public class HelloBeansSpringTest {
	
	@Autowired
	// 타입이 겹칠 경우 id가 동일한 객체를 가져옴
	// 위의 어노테이션을 붙히는 순간 가져옴 == 객체 선언 == getBean한거랑 똑같음
	Hello myHello;

	@Autowired
	@Qualifier("myHelloCon")
	Hello myHelloConstructor;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Resource(name = "myHelloCollection")
	Hello myHelloCol;
	
	
	@Test @Disabled
	void hello() {
		assertEquals("Hello 스프링", myHello.sayHello());
	}
	
	@Test
	void helloCon() {
		assertEquals("Hello 생성자", myHelloConstructor.sayHello());
		assertSame(printer, myHello.printer);
		myHello.print();
		assertEquals("Hello 스프링", printer.toString());		
	}
	
}
