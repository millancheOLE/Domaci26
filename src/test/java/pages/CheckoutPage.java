package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    public WebElement getZipCode() {
        return getDriver().findElement(zipCode);
    }

    public WebElement getContinueButton() {
        return getDriver().findElement(continueButton);
    }

    public void insertData(String firstName, String lastName, String zipCode){
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getZipCode().sendKeys(zipCode);
        getContinueButton().click();
    }
}
