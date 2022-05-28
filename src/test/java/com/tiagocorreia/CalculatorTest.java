package com.tiagocorreia;

import com.tiagocorreia.testesjunit.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

  Calculator calculator;

  @Test
  public void testMultiply(){
    calculator  = new Calculator();
    assertEquals(25,calculator.myMultipli(5,5));
  }
}
