package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.*;

public class ShopSortingRating extends BaseTest {

  @Test
  public void ShouldSortingRating() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.selectSorting(SEL_RATING)
      .verifySelectSort(SEL_RATING);
  }
}
