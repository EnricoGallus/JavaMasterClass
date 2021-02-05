public class Main {
    public static void main(String[] args) {
        String numberAsString = "2018";
        System.out.println("numberAsString = " + numberAsString);

        int number = Integer.parseInt(numberAsString);
        System.out.println("number = " + number);

        String doubleAsString = "2018.125";
        double doubleNumber = Double.parseDouble(doubleAsString);
        System.out.println("double = " + doubleNumber);

        numberAsString += 1;
        System.out.println("numberAsString = " + numberAsString);
        number += 1;
        System.out.println("number = " + number);
        doubleNumber += 1;
        System.out.println("doubleNumber = " + doubleNumber);
    }
}
