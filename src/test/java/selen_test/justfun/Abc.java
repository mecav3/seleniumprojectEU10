package selen_test.justfun;

public class Abc extends Account{

    //  @Test
    public void test_login_logout() {
        int i = 0;
        while (i++ < 3) {
            for (String user : users) {
                login(user);
                logout();
            }
        }
    }

}
