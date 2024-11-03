package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenArray{
    
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
}

