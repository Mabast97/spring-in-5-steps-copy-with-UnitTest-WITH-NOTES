package com.example.springin5steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary  // When you have two @Components, you can make one of them to be a primary one.
@Qualifier("bubble")  // other option in order to resolve multiple candidates that are available
//@Scope("prototype")  // new bean created whenever requested
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // the same as line (12) but in a different style
//@Scope("singleton")  // one instance will be created per SpringContext
public class BubbleSortAlgorithm implements SortAlgorithm {

    public int[] sort(int[] numbers) {
        System.out.println("BubbleSort");
        return numbers;
    }


}
