package tests.account;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_PASSWORD;
import static constants.Constants.Login.LOGIN_USERNAME;
import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.Urls.MY_ACCOUNT_PAGE;

public class AccountDashboard extends BaseTest {

  @Test
  public void ShouldViewDashboard() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_USERNAME)
      .typePassword(LOGIN_PASSWORD)
      .clickLogin();

    myAccountPage.clickDashboard()
      .verifyMyAccountUrl(MY_ACCOUNT_PAGE);
  }
}
