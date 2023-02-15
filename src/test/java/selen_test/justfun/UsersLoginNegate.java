package selen_test.justfun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersLoginNegate extends AccountBase {

    @Test
    public void test_username() {
        int i = 0;

        while (i++ < 1) {
            pl(
                    fakeit(users.get(0))
                            + "-" + i);
            login(
                    fakeit(users.get(0))
            );
            pl("loginIsFail() = " + loginIsFail());
            Assert.assertTrue(loginIsFail());
        }
    }

    @Test
    public void test_pass() {
        int i = 0;

        while (i++ < 1) {
            pl(users.get(0) + " : " +
                    fakeit(pass)
                    + "-" + i);
            login(users.get(0), fakeit(pass));
            pl("loginIsFail() = " + loginIsFail());
            Assert.assertTrue(loginIsFail());
        }
    }

}
