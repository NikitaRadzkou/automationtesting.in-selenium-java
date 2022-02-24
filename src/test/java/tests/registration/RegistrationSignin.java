package tests.registration;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Register.REG_PASSWORD;
import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.Urls.MY_ACCOUNT_PAGE;

public class RegistrationSignin extends BaseTest {

  @Test
  public void ShouldSignIn() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    registerPage.typeEmail()
      .typePassword(REG_PASSWORD)
      .clickRegisterBtn();

    myAccountPage.verifyMyAccountUrl(MY_ACCOUNT_PAGE);
  }
}
