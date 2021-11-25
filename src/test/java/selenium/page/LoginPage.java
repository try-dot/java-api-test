package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.SystemProperties;

public class LoginPage extends BasePage{

    public By header = By.xpath("//h1");
    public By subHeaderText = By.xpath("//p[@class=\"header__content_subheading\"]");
    public By emailInput = By.id("username");
    public By passwordInput = By.id("password");
    public By signInButton = By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button");
    public By signInWithAppleButton = By.className("sign-in-with-apple-button");
    public By errorUserNameMessage = By.id("error-for-username");

    String url = SystemProperties.UI_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        typeText(emailInput, email);
    }

    public void typePassword(String password) {
        typeText(passwordInput, password);
    }

    public void clickSignInButton() {
        click(signInButton);
    }

    public LoginPage loadPage() {
        getUrl(url);
        return this;
    }
}
