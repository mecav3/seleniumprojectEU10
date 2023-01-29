package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebElement a = wd.findElement(By.xpath("//div[.=' Invalid username or password.']"));
        return a.isDisplayed();
    }

}


