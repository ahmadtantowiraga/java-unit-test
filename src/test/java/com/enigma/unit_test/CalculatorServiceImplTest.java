package com.enigma.unit_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.BeanProperty;


public class CalculatorServiceImplTest {
    private CalculatorServiceImpl calculatorServiceImpl;
    @BeforeEach
    void setUp() {
        calculatorServiceImpl=new CalculatorServiceImpl();
    }

    @Test
    public void sumShouldReturn4When2Plus2(){
        //GIven
        int a=2;
        int b=2;

        //When
        int sum =calculatorServiceImpl.sum(a,b);

        //then
        Assertions.assertEquals(4, sum);
    }

    @Test
    public void subShouldReturn2When4Min2(){
        //GIven
        int a=4;
        int b=2;
        CalculatorServiceImpl service=new CalculatorServiceImpl();

        //When
        int min =service.sub(a,b);

        //then
        Assertions.assertEquals(2, min);
    }
    @Test
    public void divideShouldReturn2When4Device2(){
        //GIven
        int a=4;
        int b=2;
        CalculatorServiceImpl service=new CalculatorServiceImpl();

        //When
        double devide =service.divide(a,b);

        //then
        Assertions.assertEquals(2, devide);
    }
    @Test
    public void multiplyShouldReturn8When4Multiply2(){
        //GIven
        int a=4;
        int b=2;
        CalculatorServiceImpl service=new CalculatorServiceImpl();

        //When
        double multiply =service.multiply(a,b);

        //then
        Assertions.assertEquals(8, multiply);
    }

}
