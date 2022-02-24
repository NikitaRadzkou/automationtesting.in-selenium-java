package tests.registration;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

public class RegistrationEmptyEmailPassword extends BaseTest {

  @Test
  public void ShouldErrorMessageEmptyEmailPassword() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    registerPage.clickRegisterBtn()
      .verifyErrorMessage();
  }
}
