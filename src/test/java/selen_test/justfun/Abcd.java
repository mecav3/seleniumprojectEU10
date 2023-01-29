package selen_test.justfun;

import selen_test.SelenUtil;

public class Abcd extends Account{

    // @Test
    public void test_multi_tab() { //TODO check wait until isdisplayed
        SelenUtil.newWindow(wd, url, users.size() - 1);
        int i = -1;
        for (String handle : wd.getWindowHandles()) {
            hold();
            wd.switchTo().window(handle);
            hold();
            login(users.get(++i));
            hooold();
        }
    }

}
