package tests.account;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_PASSWORD;
import static constants.Constants.Login.LOGIN_USERNAME;
import static constants.Constants.Urls.*;

public class AccountLogOut extends BaseTest {

  @Test
  public void ShouldLogOutAccount() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_USERNAME)
      .typePassword(LOGIN_PASSWORD)
      .clickLogin();

    myAccountPage.clickLogout()
      .verifyMyAccountUrl(MY_ACCOUNT_PAGE);
  }
}