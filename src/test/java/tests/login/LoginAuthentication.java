package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_PASSWORD;
import static constants.Constants.Login.LOGIN_USERNAME;
import static constants.Constants.Urls.HOME_PAGE;

public class LoginAuthentication extends BaseTest {

  @Test
  public void ShouldNotReturnBack() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_USERNAME)
      .typePassword(LOGIN_PASSWORD)
      .clickLogin();

    myAccountPage.clickLogout()
      .returnBack();

  }
}
