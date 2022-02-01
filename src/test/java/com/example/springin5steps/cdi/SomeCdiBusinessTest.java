package com.example.springin5steps.cdi;

import com.example.springin5steps.SpringIn5StepsBasicApplication;
import com.example.springin5steps.basic.BinarySearchImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/* Now we want to test the Business with different kinds of data, for example different values in the database or dynamic values.
So, we can create multiple versions of SomeCdiDao, but it is not a good solution. Instead, we can create mocks of SomeCdiDao.
and will write a lot of unit tests to test the cdiBusiness
*/

// When we write the test with Mockito, we don't need spring context, that is why we remove bellow lines (that are commented)
//@RunWith(SpringRunner.class)  // loading the specific context
//@ContextConfiguration( classes = SpringIn5StepsBasicApplication.class )  // defining the context configuration
@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

    //Inject Mock
    @InjectMocks
    SomeCdiBusiness business;

    // Create Mock
    @Mock
    SomeCdiDao daoMock;

    @Test
    public void testBasicScenario() {
        // when daoMockk.getData() method is called, return in[]{2,4}
        Mockito.when(daoMock.getData()).thenReturn(new int[]{2,4});

        // call the method on binarySearch
        int actualResult = business.findGreatest();

        // check if the value is correct
        assertEquals(4, actualResult);
    }

    @Test
    public void testBasicScenario_NoElements() {
        Mockito.when(daoMock.getData()).thenReturn(new int[]{});

        // call the method on binarySearch
        int actualResult = business.findGreatest();

        // check if the value is correct
        assertEquals(Integer.MIN_VALUE, actualResult);
    }

    @Test
    public void testBasicScenario_EqualElements() {
        Mockito.when(daoMock.getData()).thenReturn(new int[]{2,2});

        // call the method on binarySearch
        int actualResult = business.findGreatest();

        // check if the value is correct
        assertEquals(2, actualResult);
    }
}