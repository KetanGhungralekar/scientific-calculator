package com.calculator;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n=== Scientific Calculator ===");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log (ln)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double num1 = scanner.nextDouble();
                        System.out.println("√" + num1 + " = " + sqrt(num1));
                        break;

                    case 2:
                        System.out.print("Enter integer: ");
                        int n = scanner.nextInt();
                        System.out.println(n + "! = " + factorial(n));
                        break;

                    case 3:
                        System.out.print("Enter number (>0): ");
                        double num2 = scanner.nextDouble();
                        System.out.println("ln(" + num2 + ") = " + ln(num2));
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = scanner.nextDouble();
                        System.out.println(base + "^" + exp + " = " + power(base, exp));
                        break;

                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // clear input buffer
            }
        }
    }
}