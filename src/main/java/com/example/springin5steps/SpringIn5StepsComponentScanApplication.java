package com.example.springin5steps;

import com.example.springin5steps.scope.PersonDAO;
import componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // this annotation automatically scans the package and the sub packages of the package where this is in for beans
// So, in here, we should tell the spring and the program to scan for the beans inside of the other package, that is why we should use the bellow line of code
@ComponentScan("componentscan") // So, it works like a search for the program in order to find the beans for our application, note that (componentscan) inside (@ComponentScan(componentscan)) is the package name.
public class SpringIn5StepsComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

	public static void main(String[] args) {

		/* AFTER WE ADDED SPRING ANNOTATIONS, WE DON'T NEED THIS LINES MORE.
		// SortAlgorithm is a dependency of the binarySearch. So, binarySearch depends on the SortAlgorithm.
		BinarySearchImp binarySearchImp = new BinarySearchImp(new QuickSortAlgorithm());
		 */

		// ApplicationContext is the one that maintain the beans
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsComponentScanApplication.class, args);
		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

		LOGGER.info("{}", componentDAO);

		// Here, JdbcConnection's Scope is (singleton), that is why both of the instances are the same.
		// But in personDao, the scope is (prototype), that is why they are different objects.


//		System.out.println("Result : " + binarySearchImp.getClass());

	}

}
