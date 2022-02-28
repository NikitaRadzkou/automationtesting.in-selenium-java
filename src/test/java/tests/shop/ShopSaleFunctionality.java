package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class ShopSaleFunctionality extends BaseTest {

  @Test
  public void ShouldSaleFunctionality() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickSaleItem();

    itemPage.verifyNewAndOldPrice();
  }
}
