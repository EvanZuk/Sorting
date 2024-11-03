package src;

import javax.swing.*;
import java.awt.*;

public class SortingVisualizer extends JPanel {
    private int[] array; // The array to be sorted

    public SortingVisualizer(int[] array, int delay) {
        this.array = array;
        //this.delay = delay;
        setPreferredSize(new Dimension(800, 600)); // Set the size of the window
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArray(g);
    }

    private void drawArray(Graphics g) {
        int width = getWidth() / array.length;
        for (int i = 0; i < array.length; i++) {
            int height = array[i] * 5; // Scale height for visibility
            g.setColor(Color.BLUE); // Set default color
            g.fillRect(i * width, getHeight() - height, width, height);
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