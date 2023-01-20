package selen_test.homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileage extends ToBeExtend {
    @Test
    public void test1() {
        wd.get("https://www.calculator.net");
        wd.findElement(By.cssSelector("input#calcSearchTerm")).sendKeys("gas mileage");
        wd.findElement(By.xpath("//a[.='Gas Mileage Calculator']")).click();

        Assert.assertEquals(wd.getTitle(), "Gas Mileage Calculator");
        Assert.assertTrue(wd.findElement(By.tagName("h1")).isDisplayed());

    }

    @Test
    public void test2() {
        wd.findElement(By.cssSelector("input#mucodreading")).clear();
        wd.findElement(By.cssSelector("input#mucodreading")).sendKeys("7925");

        wd.findElement(By.cssSelector(" input#mupodreading")).clear();
        wd.findElement(By.cssSelector(" input#mupodreading")).sendKeys("7550");

        wd.findElement(By.cssSelector("#mugasputin")).clear();
        wd.findElement(By.cssSelector("#mugasputin")).sendKeys("16");

        wd.findElement(By.cssSelector("#mugasprice")).clear();
        wd.findElement(By.cssSelector("#mugasprice")).sendKeys("3.55");

        wd.findElement(By.xpath("//*[@id=\"metric\"]/tbody/tr[5]/td/input")).click();
        Assert.assertTrue(wd.findElement(By.xpath("//font//b")).getText().contains("23.44"));
    }
}
/**
 * //tagName[contains(@attr, 'value')]
 * Task #: Gas Mileage Calculator Automation Test
 * 1. Add a new class GasMileageCalculatorTest
 * 2. Go to https://www.calculator.net
 * 3. Search for “gas mileage” using search box
 * 4. Click on the “Gas Mileage Calculator” link
 * 5. On Next page verify:
 * a. Title equals: “Gas Mileage Calculator”
 * b. “Gas Mileage Calculator” label is displayed
 * <p>
 * 6. Locate, clear and type “7925” into “Current odometer” field
 * 7. Locate, clear and type “7550” into “Previous odometer” field
 * 8. Locate, clear and type “16” into “Gas added” field
 * 9. Locate, clear and type “3.55” into “Gas price” field
 * 10. Click on Calculate button
 * 11. Verify mpg value is as expected:
 * Expected value: “23.44 mpg”
 */
