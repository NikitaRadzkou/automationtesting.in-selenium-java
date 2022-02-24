package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class LoginEmptyUsernameEmptyPassword extends BaseTest {

  @Test
  public void ShouldDisplayErrorWithEmptyLoginAndEmptyPassword() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.clickLogin()
      .verifyErrorMessage();
  }
}
