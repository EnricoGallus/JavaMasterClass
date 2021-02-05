import java.util.Scanner;

public class MinAndMaxInputChallenge {
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number:");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number < min) {
                    min = number;
                }

                if (number > max) {
                    max = number;
                }

                scanner.nextLine();
            } else {
                break;
            }
        }

        System.out.println("min = " + min + ", max = " + max);
        scanner.close();
    }
}
