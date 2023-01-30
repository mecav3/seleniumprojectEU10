package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import selen_test.ToBeExtend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account extends ToBeExtend {
    String url = "http://3.94.57.183:8001/";
    String pass = "Abc1";
    List<String> users = new ArrayList<>(Arrays.asList(
            "root@cydeo.com", "admin@bluetech.com", "manager@bluetech.com"));

    @BeforeClass
    public void beforeClass() {
        wd.get(url);
    }

    protected void logout() {
        wd.findElement(By.xpath("(//img)[2]")).click();
        wd.findElement(By.xpath("//a[.='Logout']")).click();
    }

    protected void logout(WebDriver wd) {
        wd.findElement(By.xpath("(//img)[2]")).click();
        wd.findElement(By.xpath("//a[.='Logout']")).click();
    }

    protected void login(String usr, String pass) {
        wd.findElement(By.id("username")).sendKeys(usr);
        wd.findElement(By.id("password")).sendKeys(pass);
        wd.findElement(By.id("login-submit")).click();
    }

    protected void login(String usr) {
        login(usr, "Abc1");
    }

    protected void login(WebDriver wd, String usr) {
        wd.findElement(By.id("username")).sendKeys(usr);
        wd.findElement(By.id("password")).sendKeys(pass);
        wd.findElement(By.id("login-submit")).click();
    }

    protected boolean loginIsFail() {
        return wd.findElement(By.xpath("//div[.=' Invalid username or password.']")).isDisplayed();
    }

    protected boolean loginIsSucces() {
        return wd.findElement(By.xpath("(//img)[2]")).isDisplayed();
    }

    protected boolean logoutIsSucces() {
        return wd.getCurrentUrl().contains("login");
    }

    protected String fakeit(String str) {
        char c = str.charAt(0);
        return str.replace(c, ++c);
    }
}


