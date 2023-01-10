package selen_test.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mynet {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver drv = new ChromeDriver();
        drv.get("https://www.mynet.com/");

        WebElement we = drv.findElement(By.xpath("//a[.='ÜYE GİRİŞİ']"));
        we.click();

        WebElement li = drv.findElement(By.xpath("//input[@id='loginuser']"));
         li.sendKeys("invalid_name");

        WebElement pw = drv.findElement(By.xpath("//input[@id='loginpassword']"));
        pw.sendKeys("invalid_pass");

        WebElement bt = drv.findElement(By.xpath("//button[@id='loginbutton']"));
        bt.click();


    }
}