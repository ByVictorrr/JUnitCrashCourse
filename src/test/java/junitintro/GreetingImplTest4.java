package junitintro;

import junitintro.Greeting;
import junitintro.GreetingImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingImplTest4 {
    private Greeting greeting;

    @Before
    public void setUp(){
       this.greeting = new GreetingImpl();
    }

    @Test
    public void greetShouldReturnAValidOutput(){
        //fail("Not yet implemented");
        String greet = this.greeting.greet("Junit");
        assertNotNull(greet);
        assertEquals("Hello Junit", greet);

    }
    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnException_For_NameIsNull(){
        this.greeting.greet(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnException_For_NameIsBlank(){
        this.greeting.greet("");
    }
    @After
    public void tearDown(){
        this.greeting = null;
    }

}
