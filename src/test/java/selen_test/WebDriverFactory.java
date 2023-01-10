package selen_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String brwsr) {
        if (getOsName().startsWith("win") && brwsr.equalsIgnoreCase("safari")) return null;
        if (getOsName().startsWith("mac") && brwsr.equalsIgnoreCase("edge")) return null;

        switch (brwsr) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
        }
        return null;
    }

    public static String getOsName() {
        return System.getProperty("os.name").toLowerCase();
    }

}
