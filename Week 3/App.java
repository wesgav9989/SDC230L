/*******************************************************************
* Name: Wesley Gavitt
* Date: 3/20/2026
* Assignment: Calculator Project Week 3
*
* This console application manages one numeric memory value and
* a collection of up to 10 integers. The program continues until
* the user chooses to quit.
*******************************************************************/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create Scanner for input
        Scanner input = new Scanner(System.in);

        // Create memory objects
        SingleMemory singleMemory = new SingleMemory();
        IntegerCollectionMemory collectionMemory = new IntegerCollectionMemory();

        // Menu choice variable
        int choice = 0;

        // Print header
        System.out.println("Project Week 3 - Calculator Memory Project - Wesley Gavitt");
        System.out.println();

        // Print welcome message
        System.out.println("Welcome to the Calculator Memory Project.");
        System.out.println("This application lets you manage one stored numeric value");
        System.out.println("and a collection of up to 10 integer values.");
        System.out.println();

        // Main loop
        while (choice != 11) {
            // Display menu
            System.out.println("Memory Menu");
            System.out.println("1. Store a single numeric value");
            System.out.println("2. Retrieve the single numeric value");
            System.out.println("3. Clear the single numeric value");
            System.out.println("4. Replace the single numeric value");
            System.out.println("5. Add an integer to the collection");
            System.out.println("6. Display all integers in the collection");
            System.out.println("7. Display the count of stored integers");
            System.out.println("8. Remove an integer from the collection");
            System.out.println("9. Display sum, average, and first-last difference");
            System.out.println("10. Display all collection details");
            System.out.println("11. Quit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    // Store a single value
                    System.out.print("Enter a numeric value to store: ");
                    double storedValue = input.nextDouble();
                    singleMemory.storeValue(storedValue);
                    System.out.println("Value stored successfully.");
                    System.out.println();
                    break;

                case 2:
                    // Retrieve the single value
                    if (singleMemory.hasValue()) {
                        System.out.println("Stored value: " + singleMemory.retrieveValue());
                    } else {
                        System.out.println("No single value is currently stored.");
                    }
                    System.out.println();
                    break;

                case 3:
                    // Clear the single value
                    if (singleMemory.hasValue()) {
                        singleMemory.clearValue();
                        System.out.println("Stored value cleared.");
                    } else {
                        System.out.println("No single value is currently stored.");
                    }
                    System.out.println();
                    break;

                case 4:
                    // Replace the single value
                    System.out.print("Enter a new numeric value: ");
                    double replacementValue = input.nextDouble();
                    singleMemory.replaceValue(replacementValue);
                    System.out.println("Stored value replaced successfully.");
                    System.out.println();
                    break;

                case 5:
                    // Add integer to collection
                    if (collectionMemory.isFull()) {
                        System.out.println("The collection is full. You cannot add more than 10 integers.");
                    } else {
                        System.out.print("Enter an integer to add: ");
                        int newInteger = input.nextInt();
                        collectionMemory.addValue(newInteger);
                        System.out.println("Integer added successfully.");
                    }
                    System.out.println();
                    break;

                case 6:
                    // Display all collection values
                    System.out.println("Stored integers: " + collectionMemory.displayValues());
                    System.out.println();
                    break;

                case 7:
                    // Display count
                    System.out.println("Count of stored integers: " + collectionMemory.getCount());
                    System.out.println();
                    break;

                case 8:
                    // Remove a value by position
                    if (collectionMemory.isEmpty()) {
                        System.out.println("The collection is empty. Nothing to remove.");
                    } else {
                        System.out.println("Stored integers: " + collectionMemory.displayValues());
                        System.out.print("Enter the index position to remove (starting at 0): ");
                        int removeIndex = input.nextInt();

                        if (collectionMemory.removeValue(removeIndex)) {
                            System.out.println("Integer removed successfully.");
                        } else {
                            System.out.println("Invalid index. No value was removed.");
                        }
                    }
                    System.out.println();
                    break;

                case 9:
                    // Display sum, average, and difference
                    if (collectionMemory.isEmpty()) {
                        System.out.println("The collection is empty.");
                    } else {
                        System.out.println("Sum: " + collectionMemory.getSum());
                        System.out.printf("Average: %.2f%n", collectionMemory.getAverage());
                        System.out.println("Difference of first and last values: "
                                + collectionMemory.getFirstLastDifference());
                    }
                    System.out.println();
                    break;

                case 10:
                    // Display all collection details
                    if (collectionMemory.isEmpty()) {
                        System.out.println("The collection is empty.");
                    } else {
                        System.out.println("Stored integers: " + collectionMemory.displayValues());
                        System.out.println("Count: " + collectionMemory.getCount());
                        System.out.println("Sum: " + collectionMemory.getSum());
                        System.out.printf("Average: %.2f%n", collectionMemory.getAverage());
                        System.out.println("Difference of first and last values: "
                                + collectionMemory.getFirstLastDifference());
                    }
                    System.out.println();
                    break;

                case 11:
                    // Quit
                    System.out.println("Thank you for using the Calculator Memory Project.");
                    break;

                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please enter a number from 1 to 11.");
                    System.out.println();
                    break;
            }
        }

        // Close scanner
        input.close();
    }
}
