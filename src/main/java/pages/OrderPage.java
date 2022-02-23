package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderPage extends BasePage {
  public OrderPage (WebDriver driver) {
    super(driver);
  }

  private final By thankForOrder = By.className("woocommerce-thankyou-order-received");

  public OrderPage verifyOrderUrl(String url) {
    String URL = driver.getCurrentUrl();
    System.out.println(URL);
    System.out.println(url);
    Assert.assertTrue(URL.contains(url));
    return this;
  }

  public OrderPage waitLoadingPage() {
    WebElement thanks = driver.findElement(thankForOrder);
    waitElementIsVisible(thanks);
    return this;
  }
}
