package selen_test.day7_webtables_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.BrowserUtils;
import selen_test.CRMUtils;
import selen_test.SelenUtil;

public class T3_CRM_Login {
    private WebDriver drv;

    @BeforeClass
    public void setUp() {
        drv = SelenUtil.getdrv("http://login1.nextbasecrm.com/");
    }


    public void crmLogin() {
        drv.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]"))
                .sendKeys("helpdesk1@cybertekschool.com");

        drv.findElement(By.xpath("//input[@name=\"USER_PASSWORD\"]"))
                .sendKeys("UserUser");

        drv.findElement(By.xpath("//input[@value=\"Log In\"]"))
                .click();

        BrowserUtils.verifyTitle(drv, "Portal");
    }

    @Test
    public void crmLogin2() {

        CRMUtils.crmLogin(drv);

        BrowserUtils.verifyTitle(drv, "(1) My tasks");
    }
@Test
    public void crmLogin3() {

        CRMUtils.crmLogin(drv,"helpdesk1@cybertekschool.com", "UserUser");

        BrowserUtils.verifyTitle(drv, "(1) My tasks");
    }
}
/**
 * TC #3: Login scenario
 * 1. Create new test and make set ups
 * 2. Go to : http://login1.nextbasecrm.com/
 * 3. Enter valid username
 * 4. Enter valid password
 * 5. Click to `Log In` button
 * 6. Verify title is as expected:
 * Expected: Portal
 * USERNAME PASSWORD
 * helpdesk1@cybertekschool.com UserUser
 * Helpdesk2@cybertekschool.com UserUse
 */
