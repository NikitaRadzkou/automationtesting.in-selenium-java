package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.BillingDetails.*;
import static constants.Constants.Urls.*;

public class ShopAddBasketVerifySpecialTax extends BaseTest {

  @Test
  public void ShouldAddBasketSpecialTax() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickAddToBasket();

    homePage.clickToCart();

    cartPage.clickProceedToCheckout();

    checkoutPage.verifyCheckoutUrl(CHECKOUT_PAGE)
      .verifyVisibleElements()
      .typeFirstName(FIRST_NAME)
      .typeLastName(LAST_NAME)
      .typeCompanyName(COMPANY)
      .typeEmail(EMAIL)
      .typePhone(PHONE)
      .selectSpecialCountry()
      .typeAddress(ADDRESS)
      .typeApartment(APARTMENT)
      .typeCity(CITY)
      .selectSpecialState()
      .typePostcode(ZIP)
      .clickPlaceOrder();


    orderPage.waitLoadingPage()
      .verifyOrderUrl(ORDER_PAGE)
      .calcTaxPriceSpecial();
  }
}
