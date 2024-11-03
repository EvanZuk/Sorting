package src;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        GenArray getArray = new GenArray();
        int[] randArray = getArray.generateRandomArray(100);

        Sort sorting = new Sort(randArray);
        int[] sortedArray = sorting.sort();

        System.out.println(Arrays.toString(randArray));
        System.out.println(Arrays.toString(sortedArray));

    }

}
