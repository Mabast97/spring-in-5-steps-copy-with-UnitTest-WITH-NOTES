package com.example.springin5steps.basic;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {

    public int[] sort(int[] numbers) {
        System.out.println("QuickSort");
        return numbers;
    }


}
