package selen_test.day12_pom_;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.Driver;
import selen_test.pages.LibraryLoginPage;

public class PomPractice {
    LibraryLoginPage libraryLoginPage;

    @BeforeClass
    public void beforeClass() {
        Driver.getDriver().get("https://library1.cydeo.com/");
        libraryLoginPage = new LibraryLoginPage();
    }

    @Test
    public void maine() {

        libraryLoginPage.inputUsername.sendKeys("something");
        libraryLoginPage.signInButton.click();

        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        Driver.closeDriver();

    }


}
