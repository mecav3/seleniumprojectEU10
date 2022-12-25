package selen_test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tesla.com");
        System.out.println( "current title : " + driver.getTitle() );
        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        driver.navigate().forward();

        Thread.sleep(1000);
        driver.navigate().refresh();

        driver.navigate().to("https://www.google.com");

driver.manage().window().maximize();
        Thread.sleep(1000);
driver.manage().window().minimize();
        System.out.println( "current title : " + driver.getTitle() );

        System.out.println("current URL : "+ driver.getCurrentUrl());

        driver.close();
    }

}
