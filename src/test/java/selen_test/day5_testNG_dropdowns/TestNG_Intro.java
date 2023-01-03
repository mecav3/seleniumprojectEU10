package selen_test.day5_testNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class is running----");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After Class is running-----");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("-----> Before Method is running");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("------> After method is running");
    }

    @Test //(priority = 1)
    public void zest1() {
        System.out.println("Test 1 is running");
        Assert.assertEquals("apple", "apple");
    }

    @Test// (priority = 2)
    public void test2() {
        System.out.println("Test 2 is running");
        Assert.assertTrue("apple".equals("apple1"));
    }


}
