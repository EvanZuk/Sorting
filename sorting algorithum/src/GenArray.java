package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenArray {
    
    // Method to generate a random array of unique integers
    public static int[] generateRandomArray(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = numbers.get(i);
        }
        return randomArray;
    }

    // Method to generate a sorted array
    public static int[] generateSortedArray(int size) {
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = i + 1; // Fill with sorted integers from 1 to size
        }
        return sortedArray;
    }

    // Method to generate an array with duplicates
    public static int[] generateArrayWithDuplicates(int size, int duplicatesCount) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        // Add duplicates
        for (int i = 0; i < duplicatesCount; i++) {
            numbers.add((int) (Math.random() * size) + 1); // Randomly add duplicates
        }
        
        Collections.shuffle(numbers); // Shuffle to randomize the order

        int[] arrayWithDuplicates = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arrayWithDuplicates[i] = numbers.get(i);
        }
        return arrayWithDuplicates;
    }
}