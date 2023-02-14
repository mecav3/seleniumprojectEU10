package selen_test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS {
    public static void count_links(WebDriver drv) {
        ((JavascriptExecutor) drv).executeScript("alert('links '+document.links.length)");
    }

    public static void count_tags(WebDriver drv, String tagname) {
        ((JavascriptExecutor) drv).executeScript("alert('" + tagname + " '+ document.getElementsByTagName('" + tagname + "').length)");
    }

    public static void js_inject(WebDriver wd, WebElement we, String text) {
        String js = "arguments[0].setAttribute('value','" + text + "')";
        ((JavascriptExecutor) wd).executeScript(js, we);
    }

    public static void scroll_to(WebDriver drv, int yy) {
        ((JavascriptExecutor) drv)
                .executeScript("window.scrollBy(0," + yy + ")");
    }

    public static void scroll_into(WebDriver drv, WebElement we) {
        ((JavascriptExecutor) drv)
                .executeScript("arguments[0].scrollIntoView(true)", we);
    }

    public static void scroll_to_end(WebDriver drv) {
        ((JavascriptExecutor) drv)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void click(WebDriver drv, WebElement we) {
        ((JavascriptExecutor) drv)
                .executeScript("arguments[0].click()", we);
    }
}
