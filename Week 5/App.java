/*******************************************************************
* Name: Wesley Gavitt
* Date: 4/3/2026
* Assignment: Final Calculator Project
*
* This console application combines all calculator project features
* into one program. It performs basic math operations, stores one
* numeric value in memory, manages a collection of up to 10 integers,
* handles invalid input with exception handling, and continues until
* the user chooses to quit.
*******************************************************************/
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calc = new Calculator();
        SingleMemory singleMemory = new SingleMemory();
        IntegerCollectionMemory collectionMemory = new IntegerCollectionMemory();

        boolean running = true;

        // Header
        System.out.println("Final Calculator Project - Wesley Gavitt");
        System.out.println();

        // Welcome message
        System.out.println("Welcome to the Final Calculator Project.");
        System.out.println("This application performs math operations, stores one value in memory,");
        System.out.println("manages a collection of integers, and handles invalid input.");
        System.out.println("Use the menu below to choose an option.");
        System.out.println();

        while (running) {
            printMainMenu();

            int choice = getIntInput(input, "Enter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    handleMathMenu(input, calc);
                    break;
                case 2:
                    handleSingleMemoryMenu(input, singleMemory);
                    break;
                case 3:
                    handleCollectionMenu(input, collectionMemory);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    System.out.println();
                    break;
            }
        }

        System.out.println("Thank you for using the Final Calculator Project.");
        input.close();
    }

    // Display the main menu
    public static void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Calculator Operations");
        System.out.println("2. Single Value Memory");
        System.out.println("3. Integer Collection Memory");
        System.out.println("4. Quit");
    }

    // Display calculator submenu
    public static void handleMathMenu(Scanner input, Calculator calc) {
        System.out.println("Calculator Operations");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        int choice = getIntInput(input, "Choose an operation: ");
        System.out.println();

        double num1 = getDoubleInput(input, "Enter the first number: ");
        double num2 = getDoubleInput(input, "Enter the second number: ");
        double result;

        switch (choice) {
            case 1:
                result = calc.add(num1, num2);
                System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, result);
                break;
            case 2:
                result = calc.subtract(num1, num2);
                System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, result);
                break;
            case 3:
                result = calc.multiply(num1, num2);
                System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    result = calc.divide(num1, num2);
                    System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, result);
                }
                break;
            default:
                System.out.println("Invalid calculator choice.");
                break;
        }

        System.out.println();
    }

    // Display single memory submenu
    public static void handleSingleMemoryMenu(Scanner input, SingleMemory singleMemory) {
        System.out.println("Single Value Memory");
        System.out.println("1. Store Value");
        System.out.println("2. Retrieve Value");
        System.out.println("3. Replace Value");
        System.out.println("4. Clear Value");

        int choice = getIntInput(input, "Choose an option: ");
        System.out.println();

        switch (choice) {
            case 1:
                double storedValue = getDoubleInput(input, "Enter a numeric value to store: ");
                singleMemory.storeValue(storedValue);
                System.out.println("Value stored successfully.");
                break;
            case 2:
                if (singleMemory.hasValue()) {
                    System.out.println("Stored value: " + singleMemory.retrieveValue());
                } else {
                    System.out.println("No value is currently stored.");
                }
                break;
            case 3:
                double newValue = getDoubleInput(input, "Enter a new numeric value: ");
                singleMemory.replaceValue(newValue);
                System.out.println("Value replaced successfully.");
                break;
            case 4:
                if (singleMemory.hasValue()) {
                    singleMemory.clearValue();
                    System.out.println("Stored value cleared.");
                } else {
                    System.out.println("No value is currently stored.");
                }
                break;
            default:
                System.out.println("Invalid memory choice.");
                break;
        }

        System.out.println();
    }

    // Display collection submenu
    public static void handleCollectionMenu(Scanner input, IntegerCollectionMemory collectionMemory) {
        System.out.println("Integer Collection Memory");
        System.out.println("1. Add Integer");
        System.out.println("2. Display All Values");
        System.out.println("3. Display Count");
        System.out.println("4. Remove Value");
        System.out.println("5. Display Sum");
        System.out.println("6. Display Average");
        System.out.println("7. Display First-Last Difference");

        int choice = getIntInput(input, "Choose an option: ");
        System.out.println();

        switch (choice) {
            case 1:
                if (collectionMemory.isFull()) {
                    System.out.println("Collection is full. You cannot add more values.");
                } else {
                    int value = getIntInput(input, "Enter an integer to add: ");
                    collectionMemory.addValue(value);
                    System.out.println("Integer added successfully.");
                }
                break;
            case 2:
                System.out.println("Stored integers: " + collectionMemory.displayValues());
                break;
            case 3:
                System.out.println("Count of stored integers: " + collectionMemory.getCount());
                break;
            case 4:
                if (collectionMemory.isEmpty()) {
                    System.out.println("Collection is empty. Nothing to remove.");
                } else {
                    System.out.println("Stored integers: " + collectionMemory.displayValues());
                    int index = getIntInput(input, "Enter the index to remove (starting at 0): ");
                    if (collectionMemory.removeValue(index)) {
                        System.out.println("Value removed successfully.");
                    } else {
                        System.out.println("Invalid index. No value was removed.");
                    }
                }
                break;
            case 5:
                if (collectionMemory.isEmpty()) {
                    System.out.println("Collection is empty.");
                } else {
                    System.out.println("Sum: " + collectionMemory.getSum());
                }
                break;
            case 6:
                if (collectionMemory.isEmpty()) {
                    System.out.println("Collection is empty.");
                } else {
                    System.out.printf("Average: %.2f%n", collectionMemory.getAverage());
                }
                break;
            case 7:
                if (collectionMemory.isEmpty()) {
                    System.out.println("Collection is empty.");
                } else {
                    System.out.println("Difference of first and last values: "
                            + collectionMemory.getFirstLastDifference());
                }
                break;
            default:
                System.out.println("Invalid collection choice.");
                break;
        }

        System.out.println();
    }

    // Get valid integer input
    public static int getIntInput(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                input.nextLine();
            }
        }
    }

    // Get valid double input
    public static double getDoubleInput(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine();
            }
        }
    }
}
