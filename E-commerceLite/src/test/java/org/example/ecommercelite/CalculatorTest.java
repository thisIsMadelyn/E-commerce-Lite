package org.example.ecommercelite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    //1. We declare the type (Calculator) and the name (undertest)
    private Calculator underTest;

    @BeforeEach
    void setUp(){
        //2. WE initialize it so it is not  null
        underTest = new Calculator();
    }

    @Test
    void testAddition(){
        //3. WE use the 'underTest' object to call the 'add' method
        int result = underTest.add(2,3);

        //4. We check if it worked
        assertEquals(5, result);
    }
}
