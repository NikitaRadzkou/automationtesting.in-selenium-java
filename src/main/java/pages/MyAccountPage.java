package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  private final By dashboard = By.xpath("//nav[@class = 'woocommerce-MyAccount-navigation']/ul/li[1]/a");
  private final By orders = By.xpath("//nav[@class = 'woocommerce-MyAccount-navigation']/ul/li[2]/a");
  private final By addresses = By.xpath("//nav[@class = 'woocommerce-MyAccount-navigation']/ul/li[4]/a");
  private final By accountDetails = By.xpath("//nav[@class = 'woocommerce-MyAccount-navigation']/ul/li[5]/a");
  private final By logout = By.xpath("//nav[@class = 'woocommerce-MyAccount-navigation']/ul/li[6]/a");
  private final By view = By.xpath("//a[contains(@class, 'view')][1]");
  private final By orderDetails = By.xpath("//table[1]");
  private final By customerDetails = By.xpath("//table[2]");
  private final By address = By.xpath("//address");
  private final By numberOrder = By.xpath("//div[@class = 'woocommerce-MyAccount-content']/p");
  private final By billingAddress = By.xpath("//div[contains(@class, 'woocommerce-Address')]/div[1]");
  private final By shippingAddress = By.xpath("//div[contains(@class, 'woocommerce-Address')]/div[1]");
  private final By editShipping = By.xpath("//div[2]/header/a");
  private final By rename = By.id("shipping_first_name");
  private final By saveAddress = By.xpath("//input[@name = 'save_address']");
  private final By message = By.className("woocommerce-message");

  public MyAccountPage verifyMyAccountUrl(String url) {
    String strUrl = driver.getCurrentUrl();
    Assert.assertEquals(strUrl, url);
    return this;
  }

  public MyAccountPage clickLogout() {
    WebElement logoutLink = driver.findElement(logout);
    waitElementIsVisible(logoutLink).click();
    return this;
  }

  public MyAccountPage clickDashboard() {
    WebElement dashboardLink = driver.findElement(dashboard);
    waitElementIsVisible(dashboardLink).click();
    return this;
  }

  public MyAccountPage clickOrders() {
    WebElement ordersLink = driver.findElement(orders);
    waitElementIsVisible(ordersLink).click();
    return this;
  }

  public MyAccountPage clickAddresses() {
    WebElement addressesLink = driver.findElement(addresses);
    waitElementIsVisible(addressesLink).click();
    return this;
  }

  public MyAccountPage clickViewBtn() {
    WebElement viewBtn = driver.findElement(view);
    waitElementIsVisible(viewBtn).click();
    return this;
  }

  public MyAccountPage verifyVisibleOrderDetails() {
    WebElement orderDetailsTable = driver.findElement(orderDetails);
    waitElementIsVisible(orderDetailsTable);
    return this;
  }

  public MyAccountPage verifyVisibleCustomerDetails() {
    WebElement customerDetailsTable = driver.findElement(customerDetails);
    waitElementIsVisible(customerDetailsTable);
    return this;
  }

  public MyAccountPage verifyVisibleAddressDetails() {
    WebElement billingAddress = driver.findElement(address);
    waitElementIsVisible(billingAddress);
    return this;
  }

  public MyAccountPage verifyVisibleNumberOrder() {
    WebElement orderNumber = driver.findElement(numberOrder);
    waitElementIsVisible(orderNumber);
    return this;
  }

  public MyAccountPage verifyVisibleAddressBilling() {
    WebElement addressBilling = driver.findElement(billingAddress);
    waitElementIsVisible(addressBilling);
    return this;
  }

  public MyAccountPage verifyVisibleAddressShipping() {
    WebElement addressShipping = driver.findElement(shippingAddress);
    waitElementIsVisible(addressShipping);
    return this;
  }

  public MyAccountPage clickEditShipping() {
    WebElement editShippingLink = driver.findElement(editShipping);
    waitElementIsVisible(editShippingLink).click();
    return this;
  }

  public MyAccountPage typeNewName(String name) {
    WebElement firstNameInput = driver.findElement(rename);
    waitElementIsVisible(firstNameInput).click();
    firstNameInput.clear();
    firstNameInput.sendKeys(name);
    return this;
  }

  public MyAccountPage clickSaveAddress() {
    WebElement saveAddressBtn = driver.findElement(saveAddress);
    waitElementIsVisible(saveAddressBtn).click();
    return this;
  }

  public MyAccountPage verifySuccessfullyMessage() {
    WebElement successfullyMessage = driver.findElement(message);
    waitElementIsVisible(successfullyMessage);
    return this;
  }

  public MyAccountPage clickAccountDetails() {
    WebElement accountDetailsLink = driver.findElement(accountDetails);
    waitElementIsVisible(accountDetailsLink).click();
    return this;
  }
}
