package src;
import java.util.Random;

public class quicksort {
    private int[] array;
    private Random rand;
    private SortingVisualizer visualizer; // Reference to the visualizer
    
    private int delay; // Delay for visualization speed

    quicksort(int[] array, SortingVisualizer visualizer, int delay) {
        this.array = array;
        this.rand = new Random();
        this.delay = delay;
        this.visualizer = visualizer; // Initialize the visualizer reference
    }

    public int[] sort() throws InterruptedException {
        int[] sortedArray = array;
        boolean isSorted = false;

        while (!isSorted) {
            int pivot = getPivot();
            int pivotVal = sortedArray[pivot];

            for (int i = 0; i < sortedArray.length; i++) {
                if (sortedArray[i] <= pivotVal) {
                    moveLeft(sortedArray, pivot, i);
                } else {
                    moveRight(sortedArray, pivot, i);
                }
            }

            // Update the visualizer after each complete pass
            visualizer.repaint();
            Thread.sleep(delay);

            isSorted = checkSort(sortedArray);
        }

        return sortedArray;
    }

    public int getPivot() {
        return rand.nextInt(array.length);
    }

    public int[] moveLeft(int[] array, int piv, int toRot) throws InterruptedException {
        if (toRot > piv) {
            int valueToMove = array[toRot];
            for (int i = toRot; i > piv; i--) {
                array[i] = array[i - 1];
            }
            array[piv] = valueToMove;

            // Notify the visualizer of the change
            visualizer.repaint();
            Thread.sleep(delay);
        }
        return array;
    }

    public int[] moveRight(int[] array, int piv, int toRot) throws InterruptedException {
        if (toRot < piv) {
            int valueToMove = array[toRot];
            for (int i = toRot; i < piv; i++) {
                array[i] = array[i + 1];
            }
            array[piv] = valueToMove;

            // Notify the visualizer of the change
            visualizer.repaint();
            Thread.sleep(delay);
        }
        return array;
    }

    public boolean checkSort(int[] toCheck) {
        for (int i = 0; i < toCheck.length - 1; i++) {
            if (toCheck[i] > toCheck[i + 1]) {
                return false;
            }
        }
        return true;
    }
}