package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InverntoryPage extends BasePage{

    private By product = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By cartIcon = By.id("//*[@id=\"shopping_cart_container\"]/a");

    public InverntoryPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getProduct() {
        return getDriver().findElement(product);
    }

    public WebElement getCartIcon() {
        return getDriver().findElement(cartIcon);
    }

    public void addProductToCart(){
        getProduct().click();
    }
}
