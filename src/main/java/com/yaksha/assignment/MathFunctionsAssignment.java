package com.yaksha.assignment;

public class MathFunctionsAssignment {

	public static void main(String[] args) {

		// Step 1: Absolute Value
		int num = -10;
		System.out.println("Absolute Value: " + Math.abs(num));

		// Step 2: Max and Min
		int num1 = 25;
		int num2 = 10;
		System.out.println("Max: " + Math.max(num1, num2));
		System.out.println("Min: " + Math.min(num1, num2));

		// Step 3: Square Root
		double sqrtNum = 25.0;
		System.out.println("Square Root: " + Math.sqrt(sqrtNum));

		// Step 4: Exponentiation
		double powerResult = Math.pow(2, 3);
		System.out.println("2^3: " + powerResult);

		// Step 5: Trigonometric Functions
		double angleInRadians = Math.toRadians(45);
		System.out.println("Sine(45 degrees): " + Math.sin(angleInRadians));

		// Step 6: Logarithmic Operations
		double logResult = Math.log(10);
		System.out.println("Natural Log of 10: " + logResult);
	}
}
