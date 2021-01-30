public class Challenge {
    public static void main(String[] args) {

        double doubleFirst = 20d;
        double doubleSecond = 80d;
        double result = (doubleFirst + doubleSecond) * 100d;
        double remainder = result % 40d;

        boolean isRemainderZero = remainder == 0 ? true : false;

        System.out.println(isRemainderZero);

        if (!isRemainderZero) {
            System.out.println("Got some remainder");
        }
    }
}
