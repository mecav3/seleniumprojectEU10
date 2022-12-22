package com.cydeo.tests.homework;

public class Facebook_Task1 {
    public static void main(String[] args) {

        System.out.println(
                SelenUtil.getdrv("https://www.facebook.com")
                        .getTitle().equals("Facebook – log in or sign up")
        );
    }
}
