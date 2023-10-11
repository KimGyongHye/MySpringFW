package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 나는  xml 대신이야!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 나 먼저 읽어!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
@ComponentScan(basePackages = {"myspring.di.annot"}) // 전략2를 자바로 만든 것
public class AnnotatedHelloConfig {

}
