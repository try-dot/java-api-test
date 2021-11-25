package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public WebElement findWebElement(By locator) {
        return (new WebDriverWait(driver, 20l))
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public List<WebElement> findWebElements(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        findWebElement(locator).click();
    }

    public void typeText(By locator, String text) {
        findWebElement(locator).sendKeys(text);
    }

    public void clearText(By locator) {
        findWebElements(locator).clear();
    }

    public String getText(By locator) {
        return findWebElement(locator).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void closeWindow() {
        driver.close();
    }


}
