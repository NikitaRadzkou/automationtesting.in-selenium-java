package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.VerifyVariable.CATEGORY_ELEMENT;

public class ShopProductCategory extends BaseTest {

  @Test
  public void ShouldOpenProductCategories() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickSomeCategory(CATEGORY_ELEMENT)
      .verifyCategoryUrl(CATEGORY_ELEMENT);
  }
}
