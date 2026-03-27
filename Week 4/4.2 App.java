/*******************************************************************
* Name: Wesley Gavitt
* Date: 3/27/2026
* Assignment: Calculator Project Week 4
*
* This console application performs division and demonstrates
* exception handling. It allows the user to enter two values,
* handles non-numeric input, prevents division by zero, and
* continues running until the user chooses to quit.
*******************************************************************/
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Variable to control program loop
        boolean running = true;

        // Print header line
        System.out.println("Project Week 4 - Calculator Exception Handling Project - Wesley Gavitt");
        System.out.println();

        // Print welcome message and instructions
        System.out.println("Welcome to the Calculator Exception Handling Project.");
        System.out.println("This application divides two numbers.");
        System.out.println("It will handle division by zero and non-numeric input.");
        System.out.println("You may continue using the program until you choose to quit.");
        System.out.println();

        // Main loop
        while (running) {
            // Display menu
            System.out.println("Menu");
            System.out.println("1. Divide two numbers");
            System.out.println("2. Quit");
            System.out.print("Enter your choice: ");

            try {
                int choice = input.nextInt();
                System.out.println();

                switch (choice) {
                    case 1:
                        // Perform division with exception handling
                        double num1 = 0;
                        double num2 = 0;
                        boolean validInput = false;

                        while (!validInput) {
                            try {
                                // Prompt for first value
                                System.out.print("Enter the first number: ");
                                num1 = input.nextDouble();

                                // Prompt for second value
                                System.out.print("Enter the second number: ");
                                num2 = input.nextDouble();

                                // Check for division by zero
                                if (num2 == 0) {
                                    throw new ArithmeticException("Division by zero");
                                }

                                // If input is valid, exit loop
                                validInput = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Please enter numeric values only.");
                                input.nextLine(); // Clear invalid input
                                System.out.println();
                            } catch (ArithmeticException e) {
                                System.out.println("Error: You cannot divide by zero. Please enter a different second number.");
                                System.out.println();
                            }
                        }

                        // Perform and display result
                        double result = num1 / num2;
                        System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, result);
                        System.out.println();
                        break;

                    case 2:
                        // Quit the program
                        running = false;
                        break;

                    default:
                        // Handle invalid menu choice
                        System.out.println("Error: Please enter 1 or 2.");
                        System.out.println();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error: Invalid menu choice. Please enter a number.");
                input.nextLine(); // Clear invalid input
                System.out.println();
            }
        }

        // Print closing message
        System.out.println("Thank you for using the Calculator Exception Handling Project.");

        // Close scanner
        input.close();
    }
}
