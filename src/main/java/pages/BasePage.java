package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public void open(String url) {
    driver.get(url);
  }

  public WebElement waitElementIsVisible(WebElement element) {
    new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
    return element;
  }

  public void returnBack() {
    driver.navigate().back();
  }

  public String getSaltString() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 10) {
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;
  }
}
