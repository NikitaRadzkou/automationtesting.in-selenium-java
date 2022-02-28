package tests.account;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_PASSWORD;
import static constants.Constants.Login.LOGIN_USERNAME;
import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.Urls.MY_ACCOUNT_DETAILS_PAGE;

public class AccountDetails extends BaseTest {

  @Test
  public void ShouldViewAccountDetails() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_USERNAME)
      .typePassword(LOGIN_PASSWORD)
      .clickLogin();

    myAccountPage.clickAccountDetails()
      .verifyMyAccountUrl(MY_ACCOUNT_DETAILS_PAGE);
  }
}
