package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

import java.util.List;
import java.util.Random;

public class RootCreateCompany extends Account {

    @Test
    public void test1_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
        pl("my summary :");
        pl("logged in to " + users.get(0));
    }

    @Test
    public void test2_create_company() {

        int i = 0;
        while (i++ < 1) {
            SelenUtil.click(wd, wd.findElement(By.id("companyCreateLink")));

            Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Company");

            List<WebElement> els = wd.findElements(By.tagName("input"));
            els.remove(0);

            els.get(0).sendKeys("title_" + new Random().nextInt(9999));
            els.get(1).sendKeys("123-456-7890");
            els.get(2).sendKeys("https://www.www.com");
            els.get(3).sendKeys("addressLine1");
            els.get(4).sendKeys("addressLine2");
            els.get(5).sendKeys("city1");
            els.get(6).sendKeys("12345-6789");
            els.get(7).sendKeys("state1");
            new Select(wd.findElement(By.id("country"))).selectByIndex(9);

            SelenUtil.click(wd, wd.findElement(By.cssSelector("button.btn.btn-success.mb-2.mb-sm-0.mr-sm-2")));
            pl("adding company "+i);
//            try {
//                if (wd.findElement(By.xpath("//li[@class='validation']")).getText().equals("This title already exists.")) {
//                    els.get(0).sendKeys("title_" + new Random().nextInt(9999));
//                    SelenUtil.click(wd, wd.findElement(By.cssSelector("button.btn.btn-success.mb-2.mb-sm-0.mr-sm-2")));
//                }
//            } catch (Exception e) {
//            }
        }

    }

    @AfterClass
    public void tearDown() {
        //  wd.quit();
        //  SelenUtil.kill_driver_process();
    }
}
