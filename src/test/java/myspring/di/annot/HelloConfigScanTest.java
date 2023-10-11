package myspring.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.config.AnnotatedHelloConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotatedHelloConfig.class, 
loader = AnnotationConfigContextLoader.class)
// 원래 1,2에서는 GenericApplicationContext에서 빈을 생성해줬는데
// 이제는 AnnotationConfigContext라는 SpringBean Conntainer를 로딩해주는 Loader클래스이다
public class HelloConfigScanTest {
	
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
	}

}
