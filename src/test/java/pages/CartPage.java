package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    private By productName = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    private By checkout = By.xpath("//*[@id=\"checkout\"]");

    public CartPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getProductName() {
        return getDriver().findElement(productName);
    }

    public WebElement getCheckout() {
        return getDriver().findElement(checkout);
    }

    public void clickCheckout(){
        getCheckout().click();
    }
}
