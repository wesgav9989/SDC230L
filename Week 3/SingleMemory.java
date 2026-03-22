/*******************************************************************
* Name: Wesley Gavitt
* Date: 3/19/2026
* Assignment: Calculator Project Week 3
*
* This class stores and manages one numeric value in memory.
*******************************************************************/
public class SingleMemory {
    private Double value;

    // Store a value in memory
    public void storeValue(double newValue) {
        value = newValue;
    }

    // Retrieve the current value
    public Double retrieveValue() {
        return value;
    }

    // Clear the value from memory
    public void clearValue() {
        value = null;
    }

    // Replace the current value
    public void replaceValue(double newValue) {
        value = newValue;
    }

    // Check if memory currently has a value
    public boolean hasValue() {
        return value != null;
    }
}
