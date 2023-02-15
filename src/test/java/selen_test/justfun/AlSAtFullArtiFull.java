package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selen_test.JS;

public class AlSAtFullArtiFull extends ManagerCreateAprovePinvoice {

    @Test
    public void test12_goto_sales_invoice() {
        wd.findElement(By.cssSelector("a[data-target='#submenu-4']")).click();
        wd.findElement(By.linkText("Sales Invoice")).click();
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Sales Invoice List");
        pl("\n-----Creating Sales Invoice");
        JS.click(wd, wd.findElement(By.id("companyCreateLink")));
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Sales Invoice");
    }

    String s_invoice;

    @Test
    public void test13_create_sale_invoice() {
        new Select(wd.findElement(By.id("client"))).selectByIndex(1);
        wd.findElement(By.name("action")).click();

        new Select(wd.findElement(By.id("product"))).selectByVisibleText(product);
        wd.findElement(By.id("quantity")).sendKeys("5");
        wd.findElement(By.id("price")).sendKeys("88");
        wd.findElement(By.id("tax")).sendKeys("7");

        wd.findElement(By.xpath("//button[@value='addItem']")).click();
        s_invoice = wd.findElement(By.id("invoiceNo")).getAttribute("value");
        pl("sale " + s_invoice);
    }

    @Test
    public void test14_approve_sale_invoice() {
        JS.click(wd, wd.findElement(By.id("companylistlink")));
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Sales Invoice List");
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        pl(" approving sale..");
        JS.click(wd,
                wd.findElement(By.xpath("//td[.='" + s_invoice + "']/following-sibling::td[6]//button[.='Approve']"))
        );
    }

    @Test
    public void test15() {

        try {
            new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        } catch (Exception e) {
            Assert.assertEquals(wd.findElement(By.xpath("(//h1)[2]")).getText(), "OOPS!");
            pl("low altitude");
            wd.findElement(By.linkText("Go Back")).click();
        }

    }

    @AfterClass
    public void tearDown() {
        // wd.quit();
        // SelenUtil.kill_driver_process();
    }
}
