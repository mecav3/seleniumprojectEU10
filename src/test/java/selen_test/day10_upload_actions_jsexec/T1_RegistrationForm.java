package selen_test.day10_upload_actions_jsexec;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import selen_test.ConfigurationReader;
import selen_test.Driver;

public class T1_RegistrationForm {

    @Test
    public void registrationFormtest() {
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker = new Faker();

        WebElement firstname = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        // userName.sendKeys(faker.name().username().replaceAll(".",""));
        String user = faker.bothify("helpdesk###");
        userName.sendKeys(user);

        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(user + "@email.com");

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.numerify("########")); // faker.internet().password();

        WebElement phone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.numerify("###-###-####"));  // faker.phoneNumber();

        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        gender.click();

        WebElement birthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("11/11/2011"); //faker.number().numberBetween(1,11);

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByIndex(faker.number().numberBetween(1,9));

    }
}

/**
 * C#1: Registration form confirmation
 * Note: Use JavaFaker OR read from configuration.properties file when possible.
 * 1. Open browser
 * 2. Go to website: https://practice.cydeo.com/registration_form
 * 3. Enter first name
 * 4. Enter last name
 * 5. Enter username
 * 6. Enter email address
 * 7. Enter password
 * 8. Enter phone number
 * 9. Select a gender from radio buttons
 * 10.Enter date of birth
 * 11.Select Department/Office
 * 12.Select Job Title
 * 13.Select programming language from checkboxes
 * 14.Click to sign up button
 * 15.Verify success message “You’ve successfully completed registration.” is
 * displayed.
 * Note:
 * 1. Use new Driver utility class and method
 * 2. User JavaFaker when possible
 * 3. User ConfigurationReader when it makes sense
 */
