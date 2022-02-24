package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_USERNAME;
import static constants.Constants.Urls.HOME_PAGE;

public class LoginCorrectUsernameEmptyPassword extends BaseTest {

  @Test
  public void ShouldDisplayErrorWithEmptyPassword() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_USERNAME)
      .clickLogin()
      .verifyErrorMessage();
  }
}
