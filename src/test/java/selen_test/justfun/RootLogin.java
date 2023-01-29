package selen_test.justfun;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RootLogin extends Account {

    @Test
    public void test1_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
    }

    @Test
    public void test2_logout() {
        logout();
        Assert.assertTrue(logoutIsSucces());
    }

    @AfterClass
    public void tearDown() {
        wd.close();
    }
}
