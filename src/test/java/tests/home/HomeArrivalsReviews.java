package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.Urls.SOME_PRODUCT_PAGE;
import static constants.Constants.VerifyVariable.ARRIVALS_LENGTH;

public class HomeArrivalsReviews extends BaseTest {

  @Test
  public void  CheckItemReviews() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickHomeBtn();

    homePage.verifyCountArrival(ARRIVALS_LENGTH)
        .clickArrivalLink();

    itemPage.verifyItemUrl(SOME_PRODUCT_PAGE)
        .clickReviews()
        .verifyReviews();

  }
}
