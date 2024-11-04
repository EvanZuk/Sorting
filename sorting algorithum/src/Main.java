package src;
import java.util.Arrays;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        try {
            GenArray getArray = new GenArray();
            int[] array = getArray.generateRandomArray(100);

            int max = getArray.getMax(array);

            System.out.println("Original Array: " + Arrays.toString(array));

            // Create an instance of SortingVisualizer with the generated array and delay
            SortingVisualizer visualizer = new SortingVisualizer(array, max);

            // Set up the JFrame
            JFrame frame = new JFrame("Sorting Visualizer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(visualizer);
            frame.pack();
            frame.setVisible(true);

            // Create an instance of quicksort with the visualizer
            quicksort sorting = new quicksort(array, visualizer, 100);
            int[] sortedArray = sorting.sort();

            System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions gracefully
        }
    }
}