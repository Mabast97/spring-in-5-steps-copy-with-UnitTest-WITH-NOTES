package com.example.springin5steps.cdi;

import org.springframework.stereotype.Component;

import javax.inject.Named;

//@Component  // in spring
@Named  // in CDI, instead of @Component
public class SomeCdiDao {

    public int[] getData() {
        return new int[] {5, 23, 80};
    }
}
