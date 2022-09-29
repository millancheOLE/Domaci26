package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout extends BasePage{

    private By sandwichButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public Logout(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getSandwichButton() {
        return getDriver().findElement(sandwichButton);
    }

    public WebElement getLogoutLink() {
        return getDriver().findElement(logoutLink);
    }

    public void logoutCheck(){
        getSandwichButton().click();
        getLogoutLink().click();
        getDriver().get("https://www.saucedemo.com/cart.html");
    }
}
