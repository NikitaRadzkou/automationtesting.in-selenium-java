package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  public MyAccountPage verifyMyAccountUrl(String url) {
    String strUrl = driver.getCurrentUrl();
    Assert.assertEquals(strUrl, url);
    return this;
  }

}
