package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selen_test.JS;

import java.util.*;

public class RootCreateAdminToAdminless extends AccountBase {
    Map<String, String> companies, admins;
    Map<String, List<String>> all;

    @Test
    public void test0_login_get_companies() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "Company List");
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));
        List<WebElement> stat = wd.findElements(By.xpath("//tbody/tr/td[7]"));

        companies = new HashMap<>();
        for (int i = 0; i < comp.size(); i++) {
            companies.put(comp.get(i).getText(), stat.get(i).getText());
        }
    }

    @Test
    public void test1_go_get_user_list() {
        wd.findElement(By.cssSelector("a.nav-link.active.bg-success-light.text-dark")).click();
        wd.findElement(By.xpath("//a[.='User Registration']")).click();
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");

        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> admin = wd.findElements(By.xpath("//tbody/tr/td[6]"));
        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));

        admins = new HashMap<>();
        for (int i = 0; i < admin.size(); i++) {
            admins.put(admin.get(i).getText(), comp.get(i).getText());
        }
    }

    @Test
    public void test2_pivot_company() {
        all = new HashMap<>();
        for (Map.Entry<String, String> comp : companies.entrySet()) {
            List<String> list = new ArrayList<>();
            for (Map.Entry<String, String> adm : admins.entrySet()) {
                if (adm.getValue().equalsIgnoreCase(comp.getKey())) {
                    list.add(adm.getKey());
                }
                all.put(comp.getKey(), list);
            }
        }
        System.out.println(" count : " + all.values().stream().filter(n -> n.size() == 0).count());
    }

    @Test
    public void test3() {
        pl("\n---------Companies with NO admin----------");
        all.forEach((company, admin) -> {
            if (admin.size() == 0) {
                pl(company);
                create_user(company);
            }
        });
    }

    public void create_user(String company) {

        JS.click(wd, wd.findElement(By.id("userCreateLink")));
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New User");

        List<WebElement> els = wd.findElements(By.tagName("input"));
        els.remove(0);

        String name = "admin" + new Random().nextInt(999);
        els.get(0).sendKeys(name);
        els.get(1).sendKeys("last_" + new Random().nextInt(99));
        els.get(2).sendKeys(name + "@xzmail.com");
        els.get(3).sendKeys("1234567890");
        els.get(4).sendKeys(pass);
        els.get(5).sendKeys(pass);
        new Select(wd.findElement(By.id("company"))).selectByVisibleText(company);

        wd.findElement(By.cssSelector("button[value='save']")).click();
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
        pl("adding user to " + company);
    }


    @AfterClass
    public void tearDown() {
        // wd.quit();
        //   SelenUtil.kill_driver_process();
    }
}
