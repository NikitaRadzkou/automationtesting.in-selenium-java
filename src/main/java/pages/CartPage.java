package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class CartPage extends BasePage {
  public CartPage(WebDriver driver) {
    super(driver);
  }

  private final By couponInput = By.id("coupon_code");
  private final By applyCouponBtn = By.cssSelector("[name='apply_coupon']");
  private final By cartDiscount = By.className("cart-discount");
  private final By error = By.className("woocommerce-error");
  private final By message = By.className("woocommerce-message");
  private final By remove = By.className("remove");
  private final By update = By.cssSelector("[name='update_cart']");
  private final By quantity = By.xpath("//div[@class='quantity']/input");
  private final By subtotal = By.xpath("//td[@data-title='Subtotal']/span");
  private final By tax = By.xpath("//td[@data-title='Roaming Tax']/span");
  private final By total = By.xpath("//td[@data-title='Total']/strong/span");
  private final By checkout = By.className("checkout-button");


  public CartPage verifyCartUrl(String url) {
    String strUrl = driver.getCurrentUrl();
    Assert.assertEquals(strUrl, url);
    return this;
  }

  public CartPage typeCoupon(String coupon) {
    WebElement couponInp = driver.findElement(couponInput);
    waitElementIsVisible(couponInp).sendKeys(coupon);
    return this;
  }

  public CartPage clickApplyCoupon() {
    WebElement applyCoupon = driver.findElement(applyCouponBtn);
    waitElementIsVisible(applyCoupon).click();
    return this;
  }

  public CartPage verifyAddCoupon() {
    WebElement discount = driver.findElement(cartDiscount);
    waitElementIsVisible(discount);
    return this;
  }

  public CartPage verifyErrorMessage() {
    WebElement errorMessage = driver.findElement(error);
    waitElementIsVisible(errorMessage);
    return this;
  }

  public CartPage clickRemoveItem() {
    WebElement removeBtn = driver.findElement(remove);
    waitElementIsVisible(removeBtn).click();
    return this;
  }

  public CartPage verifyRemoveMessage() {
    WebElement removeMessage = driver.findElement(message);
    waitElementIsVisible(removeMessage);
    return this;
  }

  public CartPage clickUpdateBasket() {
    WebElement updateBtn = driver.findElement(update);
    waitElementIsVisible(updateBtn).click();
    return this;
  }

  public CartPage typeCountBooks(String count) {
    WebElement countInput = driver.findElement(quantity);
    waitElementIsVisible(countInput).clear();
    countInput.sendKeys(count);
    return this;
  }

  public CartPage verifyUpdateMessage() {
    WebElement updateMessage = driver.findElement(message);
    waitElementIsVisible(updateMessage);
    return this;
  }

  public CartPage verifySubtotalLessTotal() {
    float subtotalPrice = Float.parseFloat(driver.findElement(subtotal).getText().trim().replaceAll("[^0-9.]", ""));
    float totalPrice = Float.parseFloat(driver.findElement(total).getText().trim().replaceAll("[^0-9.]", ""));
    Assert.assertTrue(subtotalPrice < totalPrice);
    return this;
  }

  public CartPage verifyTotalPrice() {
    float subtotalPrice = Float.parseFloat(driver.findElement(subtotal).getText().trim().replaceAll("[^0-9.]", ""));
    float roamingTax = Float.parseFloat(driver.findElement(tax).getText().trim().replaceAll("[^0-9.]", ""));
    float totalPrice = Float.parseFloat(driver.findElement(total).getText().trim().replaceAll("[^0-9.]", ""));
    float sum = subtotalPrice + roamingTax;
    Assert.assertEquals(sum, totalPrice);
    return this;
  }

  public CartPage clickProceedToCheckout() {
    WebElement checkoutBtn = driver.findElement(checkout);
    waitElementIsVisible(checkoutBtn).click();
    return this;
  }
}
