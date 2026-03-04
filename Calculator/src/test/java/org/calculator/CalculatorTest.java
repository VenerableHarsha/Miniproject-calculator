package org.calculator;
import org.junit.jupiter.api\.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest{
    @Test
    public void testAdd(){
        assertEquals(10.0,Calculator.add(4,6),0.0001);

    }
}