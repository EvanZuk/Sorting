package src;

public class Sort {
    private int[] array;

    Sort (int[] array) {
        this.array = array;
    }

    public int[] sort() {
        int[] sortedArray = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            int newPos = array[i]-1;
            sortedArray[newPos] = array[i];
        }

        return sortedArray;
    }
}