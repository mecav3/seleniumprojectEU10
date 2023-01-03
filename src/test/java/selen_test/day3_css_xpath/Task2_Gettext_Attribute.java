package selen_test.day3_css_xpath;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2_Gettext_Attribute {
    public static void main(String[] args) {
        WebDriver drv = SelenUtil.getdrv("https://login1.nextbasecrm.com");

        WebElement element = drv.findElement(By.className("login-item-checkbox-label"));
        System.out.println("Remember me on this computer".equals(
                element.getText() ));

        WebElement element1 = drv.findElement(By.className("login-link-forgot-pass"));

        System.out.println("Forgot your password?".equals(
                element1.getText()
        ));
        System.out.println("actual : " +element1.getText());
        System.out.println("expected : "+ "Forgot your password?");

        System.out.println(
              element1.getAttribute("href")
                      .contains("forgot_password=yes")
        );

        System.out.println(element1.getAttribute("href"));

        System.out.println("isDisplayed : "+
                element1 . isDisplayed()
        );
    }
}
/**
 * TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
 * 1- Open a Chrome browser
 * 2- Go to: https://login1.nextbasecrm.com/
 * 3- Verify “remember me” label text is as expected:
 * Expected: Remember me on this computer
 * 4- Verify “forgot password” link text is as expected:
 * Expected: Forgot your password?
 * 5- Verify “forgot password” href attribute’s value contains expected:
 * Expected: forgot_password=yes
 */