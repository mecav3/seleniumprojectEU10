package selen_test.homework;

import selen_test.SelenUtil;

public class Facebook_Task1 {
    public static void main(String[] args) {

        System.out.println(
                SelenUtil.getdrv("https://www.facebook.com")
                        .getTitle().equals("Facebook – log in or sign up")
        );
    }
}
