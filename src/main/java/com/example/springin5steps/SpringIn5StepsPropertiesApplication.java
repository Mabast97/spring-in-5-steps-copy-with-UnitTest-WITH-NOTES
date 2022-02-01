package com.example.springin5steps;

import com.example.springin5steps.properties.SomeExternalService;
import com.example.springin5steps.xml.XMLPersonDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication // this annotation automatically scans the package and the sub packages of the package where this is in for beans
// app.properties
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {


		try(ClassPathXmlApplicationContext applicationContext
				= new ClassPathXmlApplicationContext("applicationContext.xml"))
		{
			SomeExternalService service = applicationContext.getBean(SomeExternalService.class);

			System.out.println(service);
			System.out.println(service);
		}

	}
}
