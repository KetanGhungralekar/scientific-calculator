package com.calculator;

public class App {

    // Square root
    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    // Factorial
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative not allowed");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    // Natural log
    public static double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException("x must be > 0");
        return Math.log(x);
    }

    // Power
    public static double power(double x, double b) {
        return Math.pow(x, b);
    }

    public static void main(String[] args) {
        System.out.println("Scientific Calculator Demo:");
        System.out.println("√16 = " + sqrt(16));
        System.out.println("5! = " + factorial(5));
        System.out.println("ln(2.71) = " + ln(2.71));
        System.out.println("2^8 = " + power(2, 8));
    }
}
