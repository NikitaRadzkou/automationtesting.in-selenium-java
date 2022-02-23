package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.ARRIVALS_LENGTH;

public class HomeWithThreeArrivals extends BaseTest {

  @Test
  public void CheckThreeArrivals() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickHomeBtn();

    homePage.verifyCountArrival(ARRIVALS_LENGTH);
  }
}
