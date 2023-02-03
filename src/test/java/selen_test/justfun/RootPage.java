package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RootPage extends Account {
    Map<String, String> companies, admins;

    @Test
    public void test0_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
    }

    @Test
    public void test1_get_company() {
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "Company List");

        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));
        List<WebElement> stat = wd.findElements(By.xpath("//tbody/tr/td[7]"));

        companies = new TreeMap<>();
        for (int i = 0; i < comp.size(); i++) {
            companies.put(comp.get(i).getText(), stat.get(i).getText());
        }
    }

    @Test
    public void test2_goto_user_list() {
        wd.findElement(By.cssSelector("a.nav-link.active.bg-success-light.text-dark")).click();
        wd.findElement(By.xpath("//a[.='User Registration']")).click();
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
    }

    @Test
    public void test3_get_user_list() {
        List<WebElement> admin = wd.findElements(By.xpath("//tbody/tr/td[6]"));
        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));

        admins = new TreeMap<>();
        for (int i = 0; i < admin.size(); i++) {
            admins.put(admin.get(i).getText(), comp.get(i).getText());
        }
    }

    //  @Test
    public void test4_pivot_admin() {
        admins.forEach((user, comp) -> pl(user + "\t" + comp + "\t" + companies.get(comp)));
    }

    @Test
    public void test5_pivot_company() {


    }


    @AfterClass
    public void tearDown() {
              wd.close();
    }
}
