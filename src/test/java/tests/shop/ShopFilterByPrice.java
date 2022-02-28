package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class ShopFilterByPrice extends BaseTest {

  @Test
  public void ShouldFilterByPrice() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.changeRightSlider(450)
      .clickFilter()
      .verifyFilterPrices(450);
  }
}
