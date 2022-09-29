package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage2 extends BasePage{

    private By totalPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By finishButton = By.id("finish");

    public CheckoutPage2(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getTotalPrice() {
        return getDriver().findElement(totalPrice);
    }

    public WebElement getFinishButton() {
        return getDriver().findElement(finishButton);
    }

    public void checkTotalPrice(){
        getTotalPrice().getText();
    }

    public void clickFinish(){
        getFinishButton().click();
    }
}
