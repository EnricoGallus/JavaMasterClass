public class Challenge {
    public static void main(String[] args) {
        int number = 4;
        int finishNumber = 20;
        int totalNumber = 0;
        int evenNumberCount = 0;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }

            System.out.println("Even number = " + number);
            totalNumber += number;
            evenNumberCount++;
            if (evenNumberCount == 5) {
                break;
            }
        }

        System.out.println(totalNumber);
    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
