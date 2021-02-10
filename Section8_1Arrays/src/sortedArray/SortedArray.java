package sortedArray;

import java.util.Scanner;

public class SortedArray {

    public static void main(String[] args) {
        int[] values = getIntegers(5);
        int[] sorted = sortIntegers(values);
        printArray(sorted);
    }

    public static int[] getIntegers(int length) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + length + " integer values.\r");
        int[] values = new int[length];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        scanner.close();
        return values;
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int tmp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    tmp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = tmp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
}
