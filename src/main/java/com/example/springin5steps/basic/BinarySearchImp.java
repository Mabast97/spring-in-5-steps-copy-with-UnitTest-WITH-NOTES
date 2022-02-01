package com.example.springin5steps.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component  // To tell the spring to manage the dependencies
public class BinarySearchImp {
    // By adding @Component on (BinarySearchImp) and @Autowired on (SortAlgorithm sortAlgorithm), we tell the spring that
    // (sortAlgorithm) is the dependency for (BinarySearchImp)

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired  // to tell the spring that this is the dependency
    @Qualifier("bubble") // other option in order to resolve multiple candidates that are available
    SortAlgorithm sortAlgorithm ;

    // SortAlgorithm is the dependency for the BinarySearchImp. So, it means that the sortAlgorithm is the dependency for BinarySearchImp

    public int binarySearch (int[] numbers, int numberToSearchFor) {

        // BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        int[] sortedNumbers = sortAlgorithm.sort(numbers);

        return 3;
    }

    // As soon as the bean is created and initialized with the dependencies, the postConstruct method would be called.
    @PostConstruct
    public void postConstruct() {
        logger.info("Post Construct.");
    }

    // As soon as the bean is created and initialized with the dependencies, the postConstruct method would be called.
    @PreDestroy
    public void preDestroy() {
        logger.info("Pre Destroy.");
    }

}
