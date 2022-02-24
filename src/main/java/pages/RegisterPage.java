package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage extends BasePage {
  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  private final By email = By.id("reg_email");
  private final By password = By.id("reg_password");
  private final By register = By.cssSelector("[name='register']");
  private final By errorMessage = By.className("woocommerce-error");


  public RegisterPage typeEmail() {
    WebElement emailInput = driver.findElement(email);
    waitElementIsVisible(emailInput).sendKeys(getSaltString() + "@gmail.com");
    return this;
  }

  public RegisterPage typeIncorrectEmail() {
    WebElement emailInput = driver.findElement(email);
    waitElementIsVisible(emailInput).sendKeys(getSaltString());
    return this;
  }

  public RegisterPage typePassword(String val) {
    WebElement passwordInput = driver.findElement(password);
    waitElementIsVisible(passwordInput).sendKeys(val);
    WebElement passwordInputAdd = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(passwordInput)));
    passwordInputAdd.sendKeys("12");
    for (int i = 0; i < 2; i++) {
      try {
        passwordInputAdd.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }

    return this;
  }

  public RegisterPage clickRegisterBtn() {
    WebElement registerBtn = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(register)));
    waitElementIsVisible(registerBtn).click();
    return this;
  }

  public RegisterPage verifyEmailAttribute() {
    WebElement emailInput = driver.findElement(email);
    String par = emailInput.getAttribute("type");
    Assert.assertEquals(par, "email");
    return this;
  }

  public RegisterPage verifyErrorMessage() {
    WebElement elemMessage = driver.findElement(errorMessage);
    WebElement errorMessageUl = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(elemMessage)));
    return this;
  }
}
