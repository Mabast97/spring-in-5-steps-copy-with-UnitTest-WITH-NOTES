package com.example.springin5steps.basic;

import com.example.springin5steps.SpringIn5StepsBasicApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

// Load the context
/* here we should use the javaconfigurationapp for the binarySearchImpl. So, after we provided the class for the context,
*  we should provide the runner in order to help the context, that is why we should add @RunWith.*/
@RunWith(SpringRunner.class)  // loading the specific context
@ContextConfiguration( classes = SpringIn5StepsBasicApplication.class )  // defining the context configuration
public class BinarySearchTest {

    // Get this bean from the context
    @Autowired
    BinarySearchImp binarySearch;

    @Test
    public void testBasicScenario() {
        // call the method on binarySearch
        int actualResult = binarySearch.binarySearch(new int[]{}, 5);

        // check if the value is correct
        assertEquals(3, actualResult);
    }
}