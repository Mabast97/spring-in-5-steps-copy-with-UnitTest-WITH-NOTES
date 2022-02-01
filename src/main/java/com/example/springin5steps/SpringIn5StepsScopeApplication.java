package com.example.springin5steps;

import com.example.springin5steps.basic.BinarySearchImp;
import com.example.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // this annotation automatically scans the package and the sub packages of the package where this is in for beans
public class SpringIn5StepsScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

	public static void main(String[] args) {

		/* AFTER WE ADDED SPRING ANNOTATIONS, WE DON'T NEED THIS LINES MORE.
		// SortAlgorithm is a dependency of the binarySearch. So, binarySearch depends on the SortAlgorithm.
		BinarySearchImp binarySearchImp = new BinarySearchImp(new QuickSortAlgorithm());
		 */

		// ApplicationContext is the one that maintain the beans
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsScopeApplication.class, args);
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);

		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());

		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO.getJdbcConnection());

		// Here, JdbcConnection's Scope is (singleton), that is why both of the instances are the same.
		// But in personDao, the scope is (prototype), that is why they are different objects.


//		System.out.println("Result : " + binarySearchImp.getClass());

	}

}
