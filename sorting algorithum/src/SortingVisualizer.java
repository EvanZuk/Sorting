package src;

import javax.swing.*;
import java.awt.*;

public class SortingVisualizer extends JPanel {
    private int[] array; // The array to be sorted
    private int maxValue;

    public SortingVisualizer(int[] array, int maxValue) {
        this.array = array;
        this.maxValue = maxValue;
        setPreferredSize(new Dimension(800, 600)); // Set the size of the window
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(array.length>=810) {
        drawArrayAverage(g);
        } else {
            drawArray(g);
        }
    }

    private void drawArray(Graphics g) {
        int barGap = 1; // Gap between bars
        int totalGaps = array.length - 1; // Total number of gaps
        int totalWidth = getWidth() - (totalGaps * barGap); // Total width available for bars
        int width = totalWidth / array.length; // Width of each bar
    
        for (int i = 0; i < array.length; i++) {
            int height = (int) ((array[i] / (double) maxValue) * (getHeight() - 20)); // Scale height for visibility
            g.setColor(Color.BLUE); // Set color for the bars
            g.fillRect(i * (width + barGap), getHeight() - height, width, height); // Draw each bar with gap
        }
    }

    private void drawArrayAverage(Graphics g) {
        int barGap = 0; // Gap between bars
        int maxGroupLength = 500;
        int groupSize = (int) (array.length/maxGroupLength + 1);
        int numGroups = (array.length + groupSize - 1) / groupSize; // Calculate number of groups
        int[] averagedArray = new int[numGroups]; // Array to hold averaged values
    
        // Calculate the average for each group
        for (int i = 0; i < array.length; i++) {
            int groupIndex = i / groupSize; // Determine which group the current index belongs to
            averagedArray[groupIndex] += array[i]; // Sum the values in the group
            if ((i + 1) % groupSize == 0 || i == array.length - 1) {
                averagedArray[groupIndex] /= Math.min(groupSize, array.length - groupIndex * groupSize); // Average the group
            }
        }
    
        int totalGaps = numGroups - 1; // Total number of gaps
        int totalWidth = getWidth() - (totalGaps * barGap); // Total width available for bars
        int width = totalWidth / numGroups; // Width of each bar
    
        for (int i = 0; i < numGroups; i++) {
            int height = (int) ((averagedArray[i] / (double) maxValue) * (getHeight() - 20)); // Scale height for visibility
            g.setColor(Color.BLUE); // Set color for the bars
            g.fillRect(i * (width + barGap), getHeight() - height, width, height); // Draw each averaged bar with gap
        }
    }



    // public static void main(String[] args) {
    //     // Generate the array using GenArray and create the visualizer
    //     GenArray genArray = new GenArray();
    //     int[] array = genArray.generateRandomArray(100); // Example to generate an array of size 100
    //     SortingVisualizer visualizer = new SortingVisualizer(array, 100); // 100ms delay
    //     JFrame frame = new JFrame("Sorting Visualizer");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.add(visualizer);
    //     frame.pack();
    //     frame.setVisible(true);
    // }
}