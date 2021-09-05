package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorImplTest {
    @Test
    public void add_Should_Return_A_Result(){
        Calculator c = new CalculatorImpl();
        int result = c.add(10, 20);
        assertEquals(20, result);
    }
}
