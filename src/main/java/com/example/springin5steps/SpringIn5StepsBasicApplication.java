package com.example.springin5steps;

import com.example.springin5steps.basic.BinarySearchImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // this annotation automatically scans the package and the sub packages of the package where this is in for beans
public class SpringIn5StepsBasicApplication {

	public static void main(String[] args) {

		/* AFTER WE ADDED SPRING ANNOTATIONS, WE DON'T NEED THIS LINES MORE.
		// SortAlgorithm is a dependency of the binarySearch. So, binarySearch depends on the SortAlgorithm.
		BinarySearchImp binarySearchImp = new BinarySearchImp(new QuickSortAlgorithm());
		 */

		// ApplicationContext is the one that maintain the beans
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsBasicApplication.class, args);
		BinarySearchImp binarySearchImp = applicationContext.getBean(BinarySearchImp.class);

		int result = binarySearchImp.binarySearch(new int[]{12, 4, 6}, 3);

		System.out.println("Result : " + binarySearchImp.getClass());

	}

}
