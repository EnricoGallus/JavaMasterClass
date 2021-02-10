package minimumElementChallenge;

import java.util.Scanner;

public class MinimumElement {
    public static void main(String[] args) {

    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Integers do you want to enter?");
        int length = scanner.nextInt();
        scanner.close();
        return length;
    }

    private static int[] readElements(int length) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Please enter a number:");
            array[i] = scanner.nextInt();
        }

        scanner.close();
        return array;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}
