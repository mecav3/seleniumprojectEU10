package selen_test.justfun;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.stream.Collectors;

public class AdminsLoginOut extends RootBase {

    @Test
    public void test06_admin_active_login() {
        wd.get(url);
        pl("\n-----Testing Active Admins : ");

        for (Map.Entry<String, String> entry :
                admins.entrySet().stream().filter(n -> companies.get(n.getValue()).equalsIgnoreCase("active")).collect(Collectors.toList())
        ) {
           pl(entry.getKey());

            login(entry.getKey());
            Assert.assertTrue(loginIsSucces()); // TODO gettitle bööle olmaz şifre yok çakıyo
            logout();
            Assert.assertTrue(logoutIsSucces());

        }
    }

    @Test
    public void test07_admin_passive_login() {
        pl("\n-----Testing Passive Admins : ");

        for (Map.Entry<String, String> entry :
                admins.entrySet().stream().filter(n -> companies.get(n.getValue()).equalsIgnoreCase("passive")).collect(Collectors.toList())
        ) {
            pl(entry.getKey());

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
