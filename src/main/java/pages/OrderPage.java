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
  private final By roamingPrice = By.cssSelector(":nth-child(2) > td > .woocommerce-Price-amount");
  private final By subtotalPrice = By.cssSelector("tfoot :nth-child(1) td .amount");

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

  public OrderPage calcTaxPriceCommon() {
    double roamingPriceFloat = Double.parseDouble(driver.findElement(roamingPrice).getText().replaceAll("[^0-9.]", ""));
    double subtotalPriceFloat = Double.parseDouble(driver.findElement(subtotalPrice).getText().replaceAll("[^0-9.]", "")) * 0.05;
    Assert.assertEquals(roamingPriceFloat, subtotalPriceFloat);
    return this;
  }

  public OrderPage calcTaxPriceSpecial() {
    double roamingPriceFloat = Double.parseDouble(driver.findElement(roamingPrice).getText().replaceAll("[^0-9.]", ""));
    double subtotalPriceFloat = Double.parseDouble(driver.findElement(subtotalPrice).getText().replaceAll("[^0-9.]", "")) * 0.02;
    Assert.assertEquals(roamingPriceFloat, subtotalPriceFloat);
    return this;
  }
}
