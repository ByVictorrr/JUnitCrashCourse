package junitintro;

import junitintro.Greeting;
import junitintro.GreetingImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetingImplTest {
    private Greeting greeting;

    @BeforeEach
    public void setUp(){
       this.greeting = new GreetingImpl();
    }

    @Test
    public void greetShouldReturnAValidOutput(){
        //fail("Not yet implemented");
        String greet = this.greeting.greet("Junit");
        Assertions.assertNotNull(greet);
        Assertions.assertEquals("Hello Junit", greet);

    }
    @Test
    public void greetShouldThrowAnException_For_NameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            this.greeting.greet(null);
        });
    }


    @Test
    public void greetShouldThrowAnException_For_NameIsBlank(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            this.greeting.greet("");
        });
    }

    @AfterEach // after All is after all test methods
    public void tearDown(){
        this.greeting = null;
    }

}
