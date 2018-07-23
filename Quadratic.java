package algorithms_and_data_structures;

import java.util.Arrays;

public class Quadratic {

    public static void main(String [] args) {

        int[] array = {5, 2, 3, 1 ,6, 3, 6, 7, 3, 5, 3, 2, 1, 1, 5, 6, 23432, 90};

        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if(array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
