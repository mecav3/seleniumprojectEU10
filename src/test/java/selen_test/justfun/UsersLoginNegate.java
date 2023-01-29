package selen_test.justfun;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersLoginNegate extends Tezt {
    @Override
    @BeforeClass
    public void beforeClass() {
        wd.get(url);
    }

    protected String fakeit(String str) {
        char c = str.charAt(0);
        return str.replace(c, ++c);
    }

    @Test
    public void test_username() {
        int i = 0;

        while (i++ < 1) {
            System.out.println(
                    fakeit(users.get(0))
                            +    "-" + i);
            login(
                    fakeit(users.get(0))
            );
             System.out.println("loginIsFail() = " + loginIsFail());
            Assert.assertTrue(loginIsFail());
        }
    }

    @Test
    public void test_pass() {
        int i = 0;

        while (i++ < 1) {
            System.out.println(users.get(0) + " : " +
                    fakeit(pass)
                    +  "-" + i);
            login(users.get(0), fakeit(pass)) ;
            System.out.println("loginIsFail() = " + loginIsFail());
            Assert.assertTrue(loginIsFail());
        }
    }



}
