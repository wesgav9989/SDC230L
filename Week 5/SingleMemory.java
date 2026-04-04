/*******************************************************************
* Name: Wesley Gavitt
* Date: 4/3/2026
* Assignment: Final Calculator Project
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

    // Check if a value is stored
    public boolean hasValue() {
        return value != null;
    }
}
