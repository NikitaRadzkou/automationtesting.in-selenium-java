package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_PASSWORD;
import static constants.Constants.Urls.HOME_PAGE;

public class LoginEmptyUsernameValidPassword extends BaseTest {

  @Test
  public void ShouldDisplayErrorWithEmptyLogin() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typePassword(LOGIN_PASSWORD)
      .clickLogin()
      .verifyErrorMessage();
  }
}
