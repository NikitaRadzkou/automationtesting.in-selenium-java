package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  private final By logout = By.xpath("(//nav[@class='woocommerce-MyAccount-navigation']/ul/li/a)[last()]");

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

}
