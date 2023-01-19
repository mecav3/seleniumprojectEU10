package selen_test.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Extra_SmartBear extends ToBeExtend {
    @Test
    public void testCase1() {
        loginTosmartbear(wd);
        int count = 1;
        for (WebElement e : wd.findElements(By.tagName("a"))) {
            System.out.println(count++ + " - " + e.getText());
            System.out.println("Task 1 done");
        }
    }

    @Test
    public void testCase2() {
        wd.findElement(By.xpath("//a[.='Order']")).click();
        Select s = new Select(wd.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")));
        s.selectByVisibleText("FamilyAlbum");

        wd.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE + "2" + Keys.ENTER);

        wd.findElement(By.xpath(" ((//ol)[2])//li[1]//input")).sendKeys(new Faker().name().username());
        wd.findElement(By.xpath(" ((//ol)[2])//li[2]//input")).sendKeys("street");
        wd.findElement(By.xpath(" ((//ol)[2])//li[3]//input")).sendKeys("city");
        wd.findElement(By.xpath(" ((//ol)[2])//li[4]//input")).sendKeys("state");
        wd.findElement(By.xpath(" ((//ol)[2])//li[5]//input")).sendKeys("02325");

        wd.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_cardList_0")).click();
        wd.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("2345567854543434");
        wd.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("11/25");

        wd.findElement(By.xpath("//a[.='Process']")).click();

        Assert.assertEquals(wd.findElement(By.xpath("//strong")).getText(), "New order has been successfully added.");
        System.out.println("Task 2 done");
    }

    @Test
    public void testCase3() {
        loginTosmartbear(wd);
        wd.findElement(By.xpath("//a[.='View all orders']")).click();
        Assert.assertEquals(
                wd.findElement(By.xpath(" //td[.='Susan McLaren']//following-sibling::td[3]")).getText(),
                "01/05/2010");
        System.out.println("Task 3 done");
    }

    private void loginTosmartbear(WebDriver drv) {
        drv.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
        drv.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
        drv.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
        drv.findElement(By.cssSelector("input.button")).click();
    }
}
/**
 * TC #1: Smartbear software link verification
 * 1. Open browser
 * 2. Go to website:
 * http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 * 3. Enter username: “Tester”
 * 4. Enter password: “test”
 * 5. Click to Login button
 * 6. Print out count of all the links on landing page
 * 7. Print out each link text on this page
 * **********
 * Mini-Task: CREATE A CLASS à SmartBearUtils
 * • Create a method called loginToSmartBear
 * • This method simply logs in to SmartBear when you call it.
 * • Accepts WebDriver type as parameter
*/

/**
 * TC#2: Smartbear software order placing
 * 1. Open browser
 * 2. Go to website:
 * http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 * 3. Enter username: “Tester”
 * 4. Enter password: “test”
 * 5. Click on Login button
 * 6. Click on Order
 * 7. Select familyAlbum from product, set quantity to 2
 * 8. Click to “Calculate” button
 * 9. Fill address Info with JavaFaker
 * • Generate: name, street, city, state, zip code
 * 10. Click on “visa” radio button
 * 11. Generate card number using JavaFaker
 * 12. Click on “Process”
 * 13. Verify success message “New order has been successfully added.”
*/

/**
 * TC#3: Smartbear software order verification
 * 1. Open browser and login to Smartbear software
 * 2. Click on View all orders
 * 3. Verify Susan McLaren has order on date “01/05/2010
 */