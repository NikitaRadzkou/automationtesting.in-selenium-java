package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.*;

public class ShopSortingNewness extends BaseTest {

  @Test
  public void ShouldSortingNewness() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.selectSorting(SEL_DATE)
      .verifySelectSort(SEL_DATE);
  }
}
