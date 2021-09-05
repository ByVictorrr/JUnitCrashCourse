package spies;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

public class ListTest {
    @Mock
    ArrayList<String> myList = new ArrayList<>();

    @BeforeEach
    public void init(){
       MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test(){
        /*
        myList.add("victor");
        myList.add("renee");
        Mockito.doReturn(3).when(myList).size();
        assertSame(3, myList.size());
        when(myList.get(0)).thenReturn("rambo"); // calls read method (when myList spy)

         */
        Mockito.when(myList.get(0)).thenReturn("Rambo");
        Mockito.when(myList.size()).thenCallRealMethod();
        assertSame(3, myList.size());

    }

}
