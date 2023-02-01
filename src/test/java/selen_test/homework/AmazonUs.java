package selen_test.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.ToBeExtend;

import java.util.List;

public class AmazonUs extends ToBeExtend {
    @BeforeClass
    public void beforeClass() {
        wd.get("https://www.amazon.com");
    }

    @Test
    public void test1() {
        wd.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512" + Keys.ENTER);
        clearBrowserCache();
        wd.findElement(By.partialLinkText("iPhone 13")).click();
    }

    @Test
    public void test2() {

        List<WebElement> wes = wd.findElements(By.xpath("(//div[@id='tp-inline-twister-dim-values-container'])[3]//input"));
        wes.remove(0);

        wes.get(0).click();

        String color = wd.findElement(
                By.xpath("//*[@id=\"inline-twister-expanded-dimension-text-color_name\"]")).getText();

        String price = wd.findElement(
                By.xpath("//div[@class='a-popover a-popover-no-header a-declarative a-arrow-top']//span//span")).getText();

        String size = wd.findElement(
                By.xpath("//div[@class='a-popover a-popover-no-header a-declarative a-arrow-top']/div/div/div/div/span")).getText();

        String stock = wd.findElement(
                By.xpath("//div[@class='a-popover a-popover-no-header a-declarative a-arrow-top']//span//span/../following-sibling::div//span")).getText();

        System.out.println("iPhone 13 Size:" + size + " GB\n"+
                "Color:" + color +" Price:" + price +
                "\nStock:" + stock);

    }

    @AfterClass
    public void afterClass() {
        //    wd.quit();
    }
}