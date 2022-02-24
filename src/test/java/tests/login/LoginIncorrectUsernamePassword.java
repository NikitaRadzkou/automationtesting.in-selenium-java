package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class LoginIncorrectUsernamePassword extends BaseTest {

  @Test
  public void ShouldDisplayErrorWithIncorrectUsernamePassword() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername("test432423")
      .typePassword("34325465467534542")
      .clickLogin()
      .verifyErrorMessage();
  }
}
