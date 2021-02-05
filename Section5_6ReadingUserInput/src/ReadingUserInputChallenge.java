import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        int count = 1, sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (count <= 10) {
            System.out.println("Enter number #" + count + ":");
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                count += 1;
            }

            scanner.nextLine();
        }

        scanner.close();
        System.out.println("This is the sum:" + sum);
    }
}
