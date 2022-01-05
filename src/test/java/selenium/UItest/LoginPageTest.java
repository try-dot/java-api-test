package selenium.UItest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.LoginPage;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/selenium/driver/chromedriver.exe");
    }

    @Test
    void isDisplayedAppleLoginButton() {

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.loadPage();
        assert loginPage.findWebElement(loginPage.signInWithAppleButton).isDisplayed();
        driver.quit();

    }

    @Test
    void shouldShowUserNameErrorMessage() {

        String wrongEmail = "test@test";
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.loadPage();
        loginPage.typeEmail(wrongEmail);
        loginPage.clickSignInButton();
        assert loginPage.findWebElement(loginPage.errorUserNameMessage).isDisplayed();
        driver.quit();

    }

}
