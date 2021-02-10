package reversedArray;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        reverse(new int[] { 1, 2, 3, 4, 5 });
        reverse(new int[] { 1, 2, 3, 4, 5, 6 });
    }

    private static void reverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int element = array[i];
            int lastIndex = array.length - 1 - i;
            array[i] = array[lastIndex];
            array[lastIndex] = element;
        }

        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}
