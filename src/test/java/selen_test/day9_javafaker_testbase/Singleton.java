package selen_test.day9_javafaker_testbase;

public class Singleton {
    private Singleton() {
    }

    private static String word;

    public static String getWord() {
        if (word == null) {
            System.out.println("First time call.");
            word = " something";
        } else System.out.println("has already value");
        return word;
    }
}
