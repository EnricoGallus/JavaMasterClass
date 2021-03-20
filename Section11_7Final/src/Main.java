public class Main {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        //one.instanceNumber = 5;

        System.out.println(Math.PI);

        //Math math = new Math();

        int pwKey =  671231;
        Password password = new ExtendedPassword(pwKey);
        password.storePassword();
        password.letMeIn(35492839);
        password.letMeIn(1);
        password.letMeIn(pwKey);

        SIBTest test = new SIBTest();
        test.someMethod();
    }
}
