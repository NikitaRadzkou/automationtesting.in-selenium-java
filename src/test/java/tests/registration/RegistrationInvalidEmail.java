package tests.registration;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Register.REG_PASSWORD;
import static constants.Constants.Urls.HOME_PAGE;

public class RegistrationInvalidEmail extends BaseTest {

  @Test
  public void ShouldErrorMessageInvalidEmail() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    registerPage.typeIncorrectEmail()
      .typePassword(REG_PASSWORD)
      .clickRegisterBtn()
      .verifyEmailAttribute();
  }
}
