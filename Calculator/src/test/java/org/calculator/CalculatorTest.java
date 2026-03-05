package org.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    /* ADD */

    @Test
    public void testAddPositive(){
        assertEquals(10.0, Calculator.add(4,6), 0.0001);
    }

    @Test
    public void testAddNegative(){
        assertEquals(-2.0, Calculator.add(-4,2), 0.0001);
    }

    @Test
    public void testAddZero(){
        assertEquals(5.0, Calculator.add(5,0), 0.0001);
    }

    /* SUBTRACT */

    @Test
    public void testSubPositive(){
        assertEquals(2.0, Calculator.sub(6,4), 0.0001);
    }

    @Test
    public void testSubNegative(){
        assertEquals(-10.0, Calculator.sub(-6,4), 0.0001);
    }

    @Test
    public void testSubZero(){
        assertEquals(6.0, Calculator.sub(6,0), 0.0001);
    }

    /* MULTIPLY */

    @Test
    public void testMulPositive(){
        assertEquals(24.0, Calculator.mul(6,4), 0.0001);
    }

    @Test
    public void testMulNegative(){
        assertEquals(-12.0, Calculator.mul(-3,4), 0.0001);
    }

    @Test
    public void testMulZero(){
        assertEquals(0.0, Calculator.mul(5,0), 0.0001);
    }

    /* DIVIDE */

    @Test
    public void testDivNormal(){
        assertEquals(2.0, Calculator.div(8,4), 0.0001);
    }

    @Test
    public void testDivFraction(){
        assertEquals(2.5, Calculator.div(5,2), 0.0001);
    }

    @Test
    public void testDivNegative(){
        assertEquals(-2.0, Calculator.div(-8,4), 0.0001);
    }

    /* SQRT */

    @Test
    public void testSquareRootPerfect(){
        assertEquals(5.0, Calculator.sqrroot(25), 0.0001);
    }

    @Test
    public void testSquareRootDecimal(){
        assertEquals(3.0, Calculator.sqrroot(9), 0.0001);
    }

    @Test
    public void testSquareRootOne(){
        assertEquals(1.0, Calculator.sqrroot(1), 0.0001);
    }

    /* POWER */

    @Test
    public void testPowerNormal(){
        assertEquals(16.0, Calculator.power(2,4), 0.0001);
    }

    @Test
    public void testPowerZero(){
        assertEquals(1.0, Calculator.power(5,0), 0.0001);
    }

    @Test
    public void testPowerNegative(){
        assertEquals(0.25, Calculator.power(2,-2), 0.0001);
    }

    /* NATURAL LOG */

    @Test
    public void testNaturalLogE(){
        assertEquals(1.0, Calculator.natlog(Math.E), 0.0001);
    }

    @Test
    public void testNaturalLogOne(){
        assertEquals(0.0, Calculator.natlog(1), 0.0001);
    }

    @Test
    public void testNaturalLogTen(){
        assertEquals(Math.log(10), Calculator.natlog(10), 0.0001);
    }

    /* FACTORIAL */

    @Test
    public void testFactorialNormal(){
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    public void testFactorialZero(){
        assertEquals(1, Calculator.factorial(0));
    }

    @Test
    public void testFactorialOne(){
        assertEquals(1, Calculator.factorial(1));
    }

}