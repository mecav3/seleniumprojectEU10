package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RootPage extends Account {
    Map<String, String> companies, admins;
    Map<String, List<String>> all;

    @Test
    public void test0_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
    }

    @Test
    public void test1_get_company() {
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
    public void test2_goto_user_list() {
        wd.findElement(By.cssSelector("a.nav-link.active.bg-success-light.text-dark")).click();
        wd.findElement(By.xpath("//a[.='User Registration']")).click();
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
    }

    @Test
    public void test3_get_user_list() {
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> admin = wd.findElements(By.xpath("//tbody/tr/td[6]"));
        List<WebElement> comp = wd.findElements(By.xpath("//tbody/tr/td[2]"));

        admins = new HashMap<>();
        for (int i = 0; i < admin.size(); i++) {
            admins.put(admin.get(i).getText(), comp.get(i).getText());
        }
    }

    @Test
    public void test4_pivot_admin() {
        pl("\n---------Admin Status----------");
        admins.forEach((user, comp) -> pl(user + "\t" + comp + "\t" + companies.get(comp)));
        System.out.println("Passive : " + admins.values().stream().filter(n -> companies.get(n).equalsIgnoreCase("passive")).count());
    }

    @Test
    public void test5_pivot_company() {
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

    @Test
    public void test6_admin_active_login() {
        wd.get(url);
        System.out.println("\n-----Testing Active Admins : ");

        for (Map.Entry<String, String> entry :
                admins.entrySet().stream().filter(n -> companies.get(n.getValue()).equalsIgnoreCase("active")).collect(Collectors.toList())
        ) {
            System.out.println(entry.getKey());

            login(entry.getKey());
            Assert.assertTrue(loginIsSucces()); // TODO gettitle bööle olmaz şifre yok çakıyo
            logout();
            Assert.assertTrue(logoutIsSucces());
        }
    }

    @Test
    public void test7_admin_passive_login() {
        System.out.println("\n-----Testing Passive Admins : ");

        for (Map.Entry<String, String> entry :
                admins.entrySet().stream().filter(n -> companies.get(n.getValue()).equalsIgnoreCase("passive")).collect(Collectors.toList())
        ) {
            System.out.println(entry.getKey());

            login(entry.getKey());
            Assert.assertTrue(loginIsFail());
        }
    }

    @AfterClass
    public void tearDown() {
        // wd.quit();
        //   SelenUtil.kill_driver_process();
    }
}
