package com.holubinka.homework3.calcularor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testCalculatorWithArabicNumbers() throws Exception {
        double expectedResult = -9.0;
        double actualResult = calculator.calculate(
                calculator.ReversePolishNotation("3+6*(1-3)"), 1);
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCalculatorWithRomanNumbers() throws Exception {
        String expectedResult = "-IX";
        String actualResult = calculator.convertDecimalToRoman(calculator.calculate(
                calculator.ReversePolishNotation("III+VI*(I-III)"), 2));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculatorWithSAllNegativeArabicNumbers() throws Exception {
        double expectedResult = 21.0;
        double actualResult = calculator.calculate(
                calculator.ReversePolishNotation("-3-6*(-1-3)"), 1);
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCalculatorWithAllNegativeRomanNumbers() throws Exception {
        String expectedResult = "XXI";
        String actualResult = calculator.convertDecimalToRoman(calculator.calculate(
                calculator.ReversePolishNotation("-III-VI*(-I-III)"), 2));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatorExceptionOnDivisionByZero() throws Exception {
        calculator.calculate(
                calculator.ReversePolishNotation("1/0"), 1);
    }
}