package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
  public CheckoutPage(WebDriver driver) {
    super(driver);
  }

  private final By billingDetails = By.className("woocommerce-billing-fields");
  private final By additionalInformation = By.className("woocommerce-shipping-fields");
  private final By order = By.id("order_review");
  private final By firstName = By.id("billing_first_name");
  private final By lastName = By.id("billing_last_name");
  private final By company = By.id("billing_company");
  private final By email = By.id("billing_email");
  private final By phone = By.id("billing_phone");
  private final By address = By.id("billing_address_1");
  private final By apartment = By.id("billing_address_2");
  private final By city = By.id("billing_city");
  private final By state = By.id("billing_state");
  private final By postcode = By.id("billing_postcode");
  private final By placeOrder = By.id("place_order");

  public CheckoutPage verifyCheckoutUrl(String url) {
    String URL = driver.getCurrentUrl();
    Assert.assertTrue(URL.contains(url));
    return this;
  }

  public CheckoutPage verifyVisibleElements() {
    WebElement billingDetailsDiv = driver.findElement(billingDetails);
    WebElement additionalInformationDiv = driver.findElement(additionalInformation);
    WebElement orderDiv = driver.findElement(order);
    waitElementIsVisible(billingDetailsDiv);
    waitElementIsVisible(additionalInformationDiv);
    waitElementIsVisible(orderDiv);
    return this;
  }

  public CheckoutPage typeFirstName(String val) {
    WebElement firstNameInput = driver.findElement(firstName);
    waitElementIsVisible(firstNameInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeLastName(String val) {
    WebElement lastNameInput = driver.findElement(lastName);
    waitElementIsVisible(lastNameInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeCompanyName(String val) {
    WebElement companyInput = driver.findElement(company);
    waitElementIsVisible(companyInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeEmail(String val) {
    WebElement emailInput = driver.findElement(email);
    waitElementIsVisible(emailInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typePhone(String val) {
    WebElement phoneInput = driver.findElement(phone);
    waitElementIsVisible(phoneInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeAddress(String val) {
    WebElement addressInput = driver.findElement(address);
    waitElementIsVisible(addressInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeApartment(String val) {
    WebElement apartmentInput = driver.findElement(apartment);
    waitElementIsVisible(apartmentInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeCity(String val) {
    WebElement cityInput = driver.findElement(city);
    waitElementIsVisible(cityInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typeState(String val) {
    WebElement stateInput = driver.findElement(state);
    waitElementIsVisible(stateInput).sendKeys(val);
    return this;
  }

  public CheckoutPage typePostcode(String val) {
    WebElement postcodeInput = driver.findElement(postcode);
    waitElementIsVisible(postcodeInput).sendKeys(val);
    return this;
  }

  public CheckoutPage clickPlaceOrder() {
    WebElement placeOrderBtn = driver.findElement(placeOrder);
    waitElementIsVisible(placeOrderBtn).click();
    return this;
  }
}
