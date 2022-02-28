package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.CATEGORY_ELEMENT;
import static constants.Constants.VerifyVariable.SEL_POPULARITY;

public class ShopSortingPopularity extends BaseTest {

  @Test
  public void ShouldSortingPopularity() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.selectSorting(SEL_POPULARITY)
      .verifySelectSort(SEL_POPULARITY);
  }
}
