package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.*;

public class ShopSortingLow extends BaseTest {

  @Test
  public void ShouldSortingLow() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.selectSorting(SEL_LOW_PRICE)
      .verifySelectSort(SEL_LOW_PRICE);
  }
}
