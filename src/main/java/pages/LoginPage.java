package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  private final By username = By.id("username");
  private final By password = By.id("password");
  private final By login = By.cssSelector("[name='login']");
  private final By errorMessage = By.className("woocommerce-error");

  public LoginPage typeUsername(String val) {
    WebElement usernameInput = driver.findElement(username);
    waitElementIsVisible(usernameInput).sendKeys(val);
    return this;
  }

  public LoginPage typePassword(String val) {
    WebElement usernamePassword = driver.findElement(password);
    waitElementIsVisible(usernamePassword).sendKeys(val);
    return this;
  }

  public LoginPage clickLogin() {
    WebElement loginBtn = driver.findElement(login);
    waitElementIsVisible(loginBtn).click();
    return this;
  }

  public LoginPage verifyErrorMessage() {
    WebElement elemMessage = driver.findElement(errorMessage);
    WebElement errorMessageUl = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(elemMessage)));
    return this;
  }

  public LoginPage verifyPasswordAttribute() {
    WebElement passwordInput = driver.findElement(password);
    String par = passwordInput.getAttribute("type");
    Assert.assertEquals(par, "password");
    return this;
  }
}
