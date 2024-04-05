package com.enigma.unit_test;

public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public double divide(int a, int b) {
        return (double) a / b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
