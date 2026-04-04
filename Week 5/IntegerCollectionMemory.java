/*******************************************************************
* Name: Wesley Gavitt
* Date: 4/3/2026
* Assignment: Final Calculator Project
*
* This class stores and manages a collection of up to 10 integers.
*******************************************************************/
public class IntegerCollectionMemory {
    private int[] values;
    private int count;

    // Constructor
    public IntegerCollectionMemory() {
        values = new int[10];
        count = 0;
    }

    // Add a value if space is available
    public boolean addValue(int value) {
        if (count < values.length) {
            values[count] = value;
            count++;
            return true;
        }
        return false;
    }

    // Remove a value by index
    public boolean removeValue(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        for (int i = index; i < count - 1; i++) {
            values[i] = values[i + 1];
        }

        count--;
        return true;
    }

    // Return all stored values as a string
    public String displayValues() {
        if (count == 0) {
            return "No values stored.";
        }

        String result = "";
        for (int i = 0; i < count; i++) {
            result += values[i];
            if (i < count - 1) {
                result += ", ";
            }
        }

        return result;
    }

    // Return number of stored values
    public int getCount() {
        return count;
    }

    // Return sum of stored values
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += values[i];
        }
        return sum;
    }

    // Return average of stored values
    public double getAverage() {
        if (count == 0) {
            return 0;
        }
        return (double) getSum() / count;
    }

    // Return difference of first and last values
    public int getFirstLastDifference() {
        if (count == 0) {
            return 0;
        }
        return values[0] - values[count - 1];
    }

    // Check if collection is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if collection is full
    public boolean isFull() {
        return count == values.length;
    }
}
