/*******************************************************************
* Name: Wesley Gavitt
* Date: 3/15/2026
* Assignment: 2.2 Project
*
* This console application allows the user to select from a menu
* of mathematical operations. The program continues to run until
* the user chooses to quit.
*******************************************************************/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Create Calculator object
        Calculator calc = new Calculator();

        // Declare variables
        int choice;
        double num1;
        double num2;
        double result;
        boolean running = true;

        // Print header line
        System.out.println("Project Week 2 - Calculator Project - Wesley Gavitt");
        System.out.println();

        // Print welcome message and instructions
        System.out.println("Welcome to the Calculator Project.");
        System.out.println("Choose an operation from the menu below.");
        System.out.println("The program will continue until you choose to quit.");
        System.out.println();

        // Start loop so the program continues until the user quits
        while (running) {
            // Display menu
            System.out.println("Calculator Menu");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            // Read user menu choice
            choice = input.nextInt();
            System.out.println();

            // Process user choice
            switch (choice) {
                case 1:
                    // Addition
                    System.out.print("Enter the first number: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter the second number: ");
                    num2 = input.nextDouble();

                    result = calc.add(num1, num2);

                    System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, result);
                    System.out.println();
                    break;

                case 2:
                    // Subtraction
                    System.out.print("Enter the first number: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter the second number: ");
                    num2 = input.nextDouble();

                    result = calc.subtract(num1, num2);

                    System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, result);
                    System.out.println();
                    break;

                case 3:
                    // Multiplication
                    System.out.print("Enter the first number: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter the second number: ");
                    num2 = input.nextDouble();

                    result = calc.multiply(num1, num2);

                    System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, result);
                    System.out.println();
                    break;

                case 4:
                    // Division
                    System.out.print("Enter the first number: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter the second number: ");
                    num2 = input.nextDouble();

                    // Check for division by zero
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        System.out.println();
                    } else {
                        result = calc.divide(num1, num2);
                        System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, result);
                        System.out.println();
                    }
                    break;

                case 5:
                    // Quit the program
                    running = false;
                    break;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    System.out.println();
                    break;
            }
        }

        // Print closing message
        System.out.println("Thank you for using the Calculator Project.");

        // Close scanner
        input.close();
    }
}
