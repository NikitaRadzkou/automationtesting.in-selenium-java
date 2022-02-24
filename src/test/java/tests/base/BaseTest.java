package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import pages.*;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
  protected WebDriver driver = CommonActions.createDriver();
  protected BasePage basePage = new BasePage(driver);
  protected HomePage homePage = new HomePage(driver);
  protected ListsPage listsPage = new ListsPage(driver);
  protected ItemPage itemPage = new ItemPage(driver);
  protected CartPage cartPage = new CartPage(driver);
  protected CheckoutPage checkoutPage = new CheckoutPage(driver);
  protected OrderPage orderPage = new OrderPage(driver);
  protected RegisterPage registerPage = new RegisterPage(driver);
  protected MyAccountPage myAccountPage = new MyAccountPage(driver);
  protected LoginPage loginPage = new LoginPage(driver);

  @AfterClass
  public void clearCookiesAndLocalStorage() {
    if (CLEAR_COOKIES_AND_STORAGE) {
      JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
      driver.manage().deleteAllCookies();
      javascriptExecutor.executeScript("window.sessionStorage.clear()");
    }
  }

  @AfterClass(alwaysRun = true)
  public void closeBrowser() {
    if (HOLD_BROWSER_OPEN) {
      driver.quit();
    }
  }
}
