package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage{

    private By confirmMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public CheckoutCompletePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getConfirmMessage() {
        return getDriver().findElement(confirmMessage);
    }
}
