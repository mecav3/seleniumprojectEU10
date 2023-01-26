package selen_test.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Alodokter extends ToBeExtend {

    public void testName1() {

        //     wd.get("https://www.alodokter.com/");
//        String str = "return document.querySelector(\"#content>hero-view\").shadowRoot.querySelector(\"#searchSpecialities\").value='Dokter nemo'";
//        ((JavascriptExecutor) wd).executeScript(str);

//        js.executeScript("Array.from(document.querySelector(\"#content>hero-view\").shadowRoot.querySelectorAll(\"strong\")).find(el => el.textContent === 'Dokter Kandungan').click();");

        //    WebElement shadowHost = wd.findElement(By.cssSelector("div#content>hero-view")); // Shadow Host - root element
        //    SearchContext rootShadow = shadowHost.getShadowRoot();

        //1
        // rootShadow.findElement(By.cssSelector("#searchSpecialities")).sendKeys("Dokter nemoo");

        //2
//        rootShadow.findElement(By.cssSelector("#searchSpecialities")).click();
//        rootShadow.findElement(By.cssSelector("strong[data-permalink='dokter-kandungan']")).click();

    }

    @Test
    public void testName() {
        wd.get("https://www.alodokter.com/");
        WebElement shadowHost = wd.findElement(By.xpath("//*[@id=\"content\"]/hero-view"));
        SearchContext a = shadowHost.getShadowRoot();
        a.findElement(By.id("searchSpecialities")).sendKeys("Dokter nemoo");
    }

}
