package com.example.springin5steps.cdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

//@Component  // in spring
@Named  // in CDI, instead of @Component
public class SomeCdiBusiness {

//    @Autowired  // in spring
    @Inject  // in CDI, instead of @Autowired
    private SomeCdiDao someCdiDao;

    public SomeCdiDao getSomeCdiDao() {
        return someCdiDao;
    }

    public void setSomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

    public int findGreatest() {
        int greatest = Integer.MIN_VALUE;
        int[] data = someCdiDao.getData();
        for(int value : data) {
            if(value > greatest)
                greatest = value;
        }
        return greatest;
    }
}
