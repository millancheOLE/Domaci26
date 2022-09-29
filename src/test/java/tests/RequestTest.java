package tests;

/*
Kreirati projekat i u njemu 2 paketa:
    -pages
    -tests
Testirati rad sistema https://www.saucedemo.com
Napraviti testove za sledece stranice:
    -Login na stranicu (username: standard_user, password: secret_sauce)
    -Dodavanje jednog proizvoda(po izboru) u korpu i provera da li je proizvod dodat
    -Kupovina proizvoda (checkout)
    -Konfirmacija kupovine (provera totala, konfirmacione poruke)
    -Logout i provera otvaranja https://www.saucedemo.com/cart.html bez login-a
U paketu pages dodati sve potrebne stranice.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class RequestTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutPage2 checkoutPage2;
    private CheckoutCompletePage checkoutCompletePage;
    private Logout logout;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milla\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver, driverWait);
        inventoryPage = new InventoryPage(driver, driverWait);
        cartPage = new CartPage(driver, driverWait);
        checkoutPage = new CheckoutPage(driver, driverWait);
        checkoutPage2 = new CheckoutPage2(driver, driverWait);
        checkoutCompletePage = new CheckoutCompletePage(driver, driverWait);
        logout = new Logout(driver, driverWait);
    }

    @Test (priority = 1)
    public void testLoginPage(){
        String expectedResult = "PRODUCTS";

        Assert.assertTrue(loginPage.getUsername().isDisplayed());
        Assert.assertTrue(loginPage.getPassword().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());

        loginPage.login("standard_user", "secret_sauce");
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }

    @Test (priority = 2)
    public void testAddProductToCart(){
        Assert.assertTrue(inventoryPage.getProduct().isDisplayed());
        inventoryPage.addProductToCart();

        Assert.assertTrue(inventoryPage.getCartIcon().isDisplayed());
        WebElement cartAddedIcon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));

        Assert.assertTrue(cartAddedIcon.isDisplayed());
    }

    @Test (priority = 3)
    public void testProductCartName(){
        String expectedResult = "Sauce Labs Fleece Jacket";

        Assert.assertEquals(cartPage.getProductName().getText(), expectedResult);
    }

    @Test (priority = 4)
    public void testCheckout(){
        String expectedResult = "CHECKOUT: YOUR INFORMATION";

        inventoryPage.clickAtCartIcon();
        cartPage.clickCheckout();

        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

        Assert.assertEquals(actualResult.getText(), expectedResult);
    }

    @Test (priority = 5)
    public void testInsertInformation(){
        String expectedResult = "CHECKOUT: OVERVIEW";

        Assert.assertTrue(checkoutPage.getFirstName().isDisplayed());
        Assert.assertTrue(checkoutPage.getLastName().isDisplayed());
        Assert.assertTrue(checkoutPage.getZipCode().isDisplayed());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
        checkoutPage.insertData("Milan", "Stanojevic", "35230");

        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }

    @Test (priority = 6)
    public void testCheckoutFinalStep(){
        String expectedResult = "Total: $53.99";

        Assert.assertEquals(checkoutPage2.getTotalPrice().getText(), expectedResult);

        Assert.assertTrue(checkoutPage2.getFinishButton().isDisplayed());
        checkoutPage2.clickFinish();
    }

    @Test (priority = 7)
    public void testCheckoutComplete(){
        String expectedResult = "THANK YOU FOR YOUR ORDER";

        Assert.assertEquals(checkoutCompletePage.getConfirmMessage().getText(), expectedResult);
    }

    @Test (priority = 8)
    public void logout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logout.logoutCheck();

        WebElement error = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
