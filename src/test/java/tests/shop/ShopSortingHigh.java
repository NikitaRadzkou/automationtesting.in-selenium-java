package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.*;

public class ShopSortingHigh extends BaseTest {

  @Test
  public void ShouldSortingHigh() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.selectSorting(SEL_HIGH_PRICE)
      .verifySelectSort(SEL_HIGH_PRICE);
  }
}
