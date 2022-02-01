package com.example.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// this class is for demonstrating how to read values from external properties file
@Component
public class SomeExternalService {

    // from property file
    @Value("${external.service.url}")
    private String url;

    public String returnServiceURL() {
        return url;
    }
}
