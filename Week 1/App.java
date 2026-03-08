/*******************************************************************
* Name: Wesley Gavitt
* Date: 3/8/2026
* Assignment: Calculator Project Week 1
*
* This console application performs basic calculator operations.
* It displays a header, provides instructions to the user,
* adds two integer values, subtracts two floating-point values,
* and prints a closing thank-you message.
*/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Print project header line
        System.out.println("Project Week 1 - Calculator Project - Wesley Gavitt");
        System.out.println();

        // Print welcome and instructions
        System.out.println("Welcome to the Calculator Project.");
        System.out.println("You will enter two integer values to add.");
        System.out.println("Then you will enter two decimal values to subtract.");
        System.out.println();

        // Declare variables for integer section
        int intNum1;
        int intNum2;
        int intSum;

        // Prompt user for two integers
        System.out.print("Enter the first integer: ");
        intNum1 = input.nextInt();

        System.out.print("Enter the second integer: ");
        intNum2 = input.nextInt();

        // Add the two integers
        intSum = intNum1 + intNum2;

        // Display integer result
        System.out.println("Integer Addition Result: " + intNum1 + " + " + intNum2 + " = " + intSum);
        System.out.println();

        // Declare variables for floating-point section
        double decNum1;
        double decNum2;
        double decResult;

        // Prompt user for two floating-point numbers
        System.out.print("Enter the first decimal number: ");
        decNum1 = input.nextDouble();

        System.out.print("Enter the second decimal number: ");
        decNum2 = input.nextDouble();

        // Subtract the first value from the second value
        decResult = decNum2 - decNum1;

        // Display floating-point result
        System.out.printf("Decimal Subtraction Result: %.2f - %.2f = %.2f%n", decNum2, decNum1, decResult);
        System.out.println();

        // Print closing message
        System.out.println("Thank you for using the Calculator Project.");

        // Close scanner
        input.close();
    }
}
