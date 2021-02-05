import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                scanner.nextLine();
                count++;
            } else {
                break;
            }
        }

        System.out.println("SUM = " + sum + " AVG = " + (count == 0 ? 0 : Math.round(sum / (double)count)));
        scanner.close();
    }
}
