package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selen_test.JS;

public class EmployeeAprovalPinvoice extends EmployeeCreatePinvoice {

    @Test
    public void test11_approve_purchase_invoice() {

        logout();
        logoutIsSucces();
        login(e_manager);
        loginIsSucces();

        wd.findElement(By.cssSelector("a[data-target='#submenu-4']")).click();
        wd.findElement(By.linkText("Purchase Invoice")).click();
        Assert.assertEquals(wd.findElement(By.tagName("h2")).getText(), "Purchase Invoice List");

        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        pl(" approving..");
        JS.click(wd,
  wd.findElement(By.xpath("//td[.='" + e_invoice + "']/following-sibling::td[6]//button[.='Approve']"))
        );
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        pl(" approved");
    }

}
