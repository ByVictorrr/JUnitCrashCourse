package scrapbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class ATest {

    @Mock
    B b;
    private A a;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.a = new A(this.b);
    }
    @Test
    public void usesVoidMethod_Should_Call_The_Void_Method() throws Exception {
        doThrow(Exception.class).when(this.b).voidmethod();
        Assertions.assertThrows(RuntimeException.class, ()->{
            a.usesVoidMethod();
        });
    }

    @Test
    public void usesVoidMethod_Should_Throw_Runtime_Exception() throws Exception{
        doThrow(Exception.class).when(this.b).voidmethod();
        Assertions.assertThrows(RuntimeException.class, ()->{
            this.a.usesVoidMethod();
        });
    }

    @Test
    public void usesVoidMethod_test_Consecutive_Calls() throws Exception {
        doNothing().doThrow(Exception.class).when(this.b).voidmethod();
        // first call
        assertSame(1, a.usesVoidMethod());
        // second call
        Assertions.assertThrows(RuntimeException.class, ()->{
            this.a.usesVoidMethod();
        });
        verify(this.b, times(2)).voidmethod();
    }
}