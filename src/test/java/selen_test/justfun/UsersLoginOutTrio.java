package selen_test.justfun;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class UsersLoginOutTrio extends AccountBase {

    @Test
    public void test1() {
        int i = 0;
        wd.get(url);
        while (i++ < 1) {
            pl(users.get(0) + "-" + i);
            login(wd, users.get(0));
            logout(wd);
        }
    }

    @Test
    public void test3() {
        int i = 0;
        WebDriver wd2 = new ChromeDriver();
        wd2.manage().window().setPosition(new Point(200, 200));
        wd2.get(url);
        while (i++ < 1) {
            pl(users.get(2) + "-" + i);
            login(wd2, users.get(2));
            logout(wd2);
        }
        wd2.quit();
    }

    @Test
    public void test2() {
        int i = 0;
        WebDriver wd1 = new ChromeDriver();
        wd1.manage().window().setPosition(new Point(100, 100));
        wd1.get(url);

        while (i++ < 1) {
            pl(users.get(1) + "-" + i);
            login(wd1, users.get(1));
            logout(wd1);
        }
        wd1.quit();
    }

    @AfterClass
    public void afterClass() {
        wd.quit();
    }
}
