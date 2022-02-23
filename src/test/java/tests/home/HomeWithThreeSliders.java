package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.SLIDES_LENGTH;

public class HomeWithThreeSliders extends BaseTest {

  @Test
  public void CheckThreeSliders() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickHomeBtn();

    homePage.verifyCountSlide(SLIDES_LENGTH);
  }

}
