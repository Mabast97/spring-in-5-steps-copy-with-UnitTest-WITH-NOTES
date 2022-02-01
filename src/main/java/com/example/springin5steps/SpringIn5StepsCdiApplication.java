package com.example.springin5steps;

import com.example.springin5steps.cdi.SomeCdiBusiness;
import com.example.springin5steps.cdi.SomeCdiDao;
import com.example.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // this annotation automatically scans the package and the sub packages of the package where this is in for beans
public class SpringIn5StepsCdiApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCdiApplication.class);

	public static void main(String[] args) {

		/* AFTER WE ADDED SPRING ANNOTATIONS, WE DON'T NEED THIS LINES MORE.
		// SortAlgorithm is a dependency of the binarySearch. So, binarySearch depends on the SortAlgorithm.
		BinarySearchImp binarySearchImp = new BinarySearchImp(new QuickSortAlgorithm());
		 */

		// ApplicationContext is the one that maintain the beans
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsCdiApplication.class, args);
		SomeCdiBusiness business = applicationContext.getBean(SomeCdiBusiness.class);

		LOGGER.info("{} dao-{}", business);

		// Here, JdbcConnection's Scope is (singleton), that is why both of the instances are the same.
		// But in personDao, the scope is (prototype), that is why they are different objects.


//		System.out.println("Result : " + binarySearchImp.getClass());

	}

}
