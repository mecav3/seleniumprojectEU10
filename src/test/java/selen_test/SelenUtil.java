package selen_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SelenUtil {

    public static void newWindow(WebDriver wd, String url, int repeat) {
        for (int i = 0; i < repeat; i++)
            newWindow(wd, url);
    }

    public static void newWindow(WebDriver wd, String url) {
        ((JavascriptExecutor) wd).executeScript(
                "window.open(" +
                        "'" + url + "'" +
                        ",'_blank');"
        );
    }

    public static WebDriver getdrv(String url) {
        WebDriver webDriver = getdrv();
        webDriver.get(url);
        return webDriver;
    }

    public static WebDriver getdrv() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000.0));
        } catch (InterruptedException ignored) {
        }
    }

    public static void js_inject(WebDriver wd, WebElement we, String text) {
        String js = "arguments[0].setAttribute('value','" + text + "')";
        ((JavascriptExecutor) wd).executeScript(js, we);
    }

}
