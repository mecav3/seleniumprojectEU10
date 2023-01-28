package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import selen_test.SelenUtil;
import selen_test.ToBeExtend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tezt extends ToBeExtend {
    String url = "http://3.94.57.183:8001/";
    String pass = "Abc1";
    List<String> users = new ArrayList<>(Arrays.asList(
            "root@cydeo.com", "admin@bluetech.com", "manager@bluetech.com"));

    // @BeforeClass
    public void beforeClass() {
        //wd.get(url);
    }

    @Test
    public void test1() {
        int i = 0;
        wd.get(url);
        while (i++ < 30) {
            System.out.println(users.get(0) + "-" + i);
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
        while (i++ < 30) {
            System.out.println(users.get(2) + "-" + i);
            login(wd2, users.get(2));
            logout(wd2);
        }
    }

    @Test
    public void test2() {
        int i = 0;
        WebDriver wd1 = new ChromeDriver();
        wd1.manage().window().setPosition(new Point(100, 100));
        wd1.get(url);

        while (i++ < 30) {
            System.out.println(users.get(1) + "-" + i);
            login(wd1, users.get(1));
            logout(wd1);
        }
    }

    //  @Test
    public void test_login() {
        login(users.get(2));
    }

    //  @Test
    public void test_logout() {
        logout();
    }

    // @Test
    public void test_multi_tab() { //TODO check wait until isdisplayed
        SelenUtil.newWindow(wd, url, users.size() - 1);
        int i = -1;
        for (String handle : wd.getWindowHandles()) {
            hold();
            wd.switchTo().window(handle);
            hold();
            login(users.get(++i));
            hooold();
        }
    }

    // @Test
    public void test_login_logout() {
        int i = 0;
        while (i++ < 10) {
            for (String user : users) {
                login(user);
                logout();
            }
        }
    }

    private void logout() {
        wd.findElement(By.xpath("(//img)[2]")).click();
        wd.findElement(By.xpath("//a[.='Logout']")).click();
    }

    private void logout(WebDriver wd) {
        wd.findElement(By.xpath("(//img)[2]")).click();
        wd.findElement(By.xpath("//a[.='Logout']")).click();
    }

    private void login(String usr, String pass) {
        wd.findElement(By.id("username")).sendKeys(usr);
        wd.findElement(By.id("password")).sendKeys(pass);
        wd.findElement(By.id("login-submit")).click();
    }

    private void login(String usr) {
        login(usr, "Abc1");
    }

    private void login(WebDriver wd, String usr) {
        wd.findElement(By.id("username")).sendKeys(usr);
        wd.findElement(By.id("password")).sendKeys(pass);
        wd.findElement(By.id("login-submit")).click();
    }

    public boolean loginIssucces() {
        WebElement a = wd.findElement(By.xpath("//div[.=' Invalid username or password.']"));
        return a.isDisplayed();
    }

}


