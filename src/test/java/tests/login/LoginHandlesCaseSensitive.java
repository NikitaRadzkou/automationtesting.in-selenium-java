package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.*;
import static constants.Constants.Urls.HOME_PAGE;

public class LoginHandlesCaseSensitive extends BaseTest {

  @Test
  public void ShouldErrorMessageHandlesCaseSensitive() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_INC_USERNAME)
      .typePassword(LOGIN_INC_PASSWORD)
      .clickLogin()
      .verifyErrorMessage();
  }
}
