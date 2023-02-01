package selen_test.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.ToBeExtend;

public class AmazonTr extends ToBeExtend {
    @BeforeClass
    public void beforeClass() {
        wd.get("https://www.amazon.com.tr");
    }

    @Test
    public void test1() {
        wd.findElement(By.cssSelector("#sp-cc-accept")).click();
        wd.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512" + Keys.ENTER);
        wd.findElement(By.partialLinkText("iPhone 13")).click();
    }

    @Test
    public void test2() {
        String title = wd.findElement(By.xpath("//tbody/tr[2]/td[2]/span")).getText();
        String stock = wd.findElement(By.cssSelector("#availability > span")).getText();
        String price = wd.findElement(By.cssSelector("#corePriceDisplay_desktop_feature_div>div>span>span>span")).getText();
        
        System.out.println(title.split("GB ")[0] + "GB\n" + "Color:" + title.split("GB ")[1] + " Price:" + price + "\nStock:" + stock);
    }

    @AfterClass
    public void afterClass() {
           wd.quit();
    }
}