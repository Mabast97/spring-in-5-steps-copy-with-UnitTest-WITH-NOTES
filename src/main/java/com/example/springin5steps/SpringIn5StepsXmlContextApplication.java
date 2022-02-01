package com.example.springin5steps;

import com.example.springin5steps.basic.BinarySearchImp;
import com.example.springin5steps.xml.XMLPersonDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication // this annotation automatically scans the package and the sub packages of the package where this is in for beans
public class SpringIn5StepsXmlContextApplication {

	public static void main(String[] args) {

		/* AFTER WE ADDED SPRING ANNOTATIONS, WE DON'T NEED THIS LINES MORE.
		// SortAlgorithm is a dependency of the binarySearch. So, binarySearch depends on the SortAlgorithm.
		BinarySearchImp binarySearchImp = new BinarySearchImp(new QuickSortAlgorithm());
		 */

		try(ClassPathXmlApplicationContext applicationContext
				= new ClassPathXmlApplicationContext("applicationContext.xml"))
		{
			XMLPersonDAO personDAO = applicationContext.getBean(XMLPersonDAO.class);

			System.out.println("personDAO : "+personDAO);
			System.out.println(personDAO.getXmljdbcConnection());
		}

	}
}
