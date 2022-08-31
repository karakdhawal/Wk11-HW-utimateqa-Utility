package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/*2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
1. LoginTest
 */
public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
        /*
    3. Write down the following test into ‘LoginTest’ class
    1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link * Verify the text ‘Welcome Back!’
     */
    public void userShouldLoginSuccessfullyWithValidCredentials () {
        clickOnElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']"));
        String actualmes = getTextFromElement(By.xpath("//h1[@class ='page__heading']"));
        System.out.println(actualmes);
        String expectedmes = "Welcome Back!";
        Assert.assertEquals(expectedmes, actualmes);
    }
    @Test
    /*2. verifyTheErrorMessage * click on the ‘Sign In’ link
     * Enter invalid username * Enter invalid password
     * Click on Login button * Verify the error message ‘Invalid email or password.’
     */
    public void verifyTheErrorMessage () {
        clickOnElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']"));
        sendKeysToElement(By.xpath("//input[@id ='user[email]']"), "lord@gmail.com");
        sendKeysToElement(By.xpath("//input[@id ='user[password]']"), "1234");
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        String actualmes = getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));
        System.out.println(actualmes);
        String expectedmes = "Invalid email or password.";
        Assert.assertEquals(expectedmes,actualmes);


    }

}
