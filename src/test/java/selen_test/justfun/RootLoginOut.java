package selen_test.justfun;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RootLoginOut extends AccountBase {

    @Test
    public void test1_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
        pl("logged in to "+users.get(0));
    }

    @Test
    public void test2_logout() {
        logout();
        Assert.assertTrue(logoutIsSucces());
        pl("logged out from " + users.get(0));
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
