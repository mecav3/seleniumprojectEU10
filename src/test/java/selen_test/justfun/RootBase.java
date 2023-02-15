package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RootBase extends AccountBase {
  public Map<String, String> companies, admins;
  public Map<String, List<String>> all;

    @Test (priority = -1)
    public void test00_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
    }

    @Test (priority = -1)
    public void test01_get_company() {
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "Company List");
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));
        List<WebElement> stat = wd.findElements(By.xpath("//tbody/tr/td[7]"));

        companies = new HashMap<>();
        for (int i = 0; i < comp.size(); i++) {
            companies.put(comp.get(i).getText(), stat.get(i).getText());
        }
    }

    @Test (priority = -1)
    public void test02_goto_user_list() {
        wd.findElement(By.cssSelector("a.nav-link.active.bg-success-light.text-dark")).click();
        wd.findElement(By.xpath("//a[.='User Registration']")).click();
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
    }

    @Test (priority = -1)
    public void test03_get_user_list() {
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> admin = wd.findElements(By.xpath("//tbody/tr/td[6]"));
        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));

        admins = new HashMap<>();
        for (int i = 0; i < admin.size(); i++) {
            admins.put(admin.get(i).getText(), comp.get(i).getText());
        }
    }

    @Test (priority = -1)
    public void test04_pivot_admin() {
        pl("\n---------Admin Status----------");
        admins.forEach((user, comp) -> pl(user + "\t" + comp + "\t" + companies.get(comp)));
        System.out.println("Passive : " + admins.values().stream().filter(n -> companies.get(n).equalsIgnoreCase("passive")).count());
    }

    @Test (priority = -1)
    public void test05_pivot_company() {
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
        pl("\n---------Companies with admin----------");
        all.forEach((company, admin) -> {
            if (admin.size() > 0) pl(company + " : " + admin);
        });

        pl("\n---------Companies with NO admin----------");
        all.forEach((company, admin) -> {
            if (admin.size() == 0) {
                pl(company);
            }
        });

        System.out.println(" count : " + all.values().stream().filter(n -> n.size() == 0).count());
    }

   // @AfterClass
   // public void tearDown() {
        // wd.quit();
        //   SelenUtil.kill_driver_process();
  //  }
}
