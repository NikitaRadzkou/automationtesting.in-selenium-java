package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class ShopReadMore extends BaseTest {

  @Test
  public void ShouldOutOfStock() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickReadMore()
      .verifyOutOfStock();
  }
}
