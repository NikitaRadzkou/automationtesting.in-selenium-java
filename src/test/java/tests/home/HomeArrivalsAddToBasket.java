package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.Urls.SOME_PRODUCT_PAGE;
import static constants.Constants.VerifyVariable.ARRIVALS_LENGTH;
import static constants.Constants.VerifyVariable.COUNT_ZERO;

public class HomeArrivalsAddToBasket extends BaseTest {

  @Test
  public void  ShouldArrivalsAddToBasket() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickHomeBtn();

    homePage.verifyCountArrival(ARRIVALS_LENGTH)
        .clickLastArrivalLink();

    itemPage.verifyItemUrl(SOME_PRODUCT_PAGE)
        .clickToBasketBtn();

    homePage.verifyCartContentsNotEquals(COUNT_ZERO);
  }
}
