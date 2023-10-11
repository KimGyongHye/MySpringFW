package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloBeanAnnotationConfig {

	@Bean
	public Printer strPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	@Qualifier("conPrinter") // 이걸 하면 객체 이름이 ""안의 이름으로 생성이 됨
	public Printer printer() {
		return new StringPrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("Java컨피그");
		hello.setPrinter(strPrinter());
		return hello;
	}
	
}
