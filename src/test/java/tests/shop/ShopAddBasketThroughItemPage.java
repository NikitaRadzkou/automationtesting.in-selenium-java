package tests.shop;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.BillingDetails.*;
import static constants.Constants.BillingDetails.ZIP;
import static constants.Constants.Urls.*;

public class ShopAddBasketThroughItemPage extends BaseTest {

  @Test
  public void ShouldAddBasketThroughItemPage() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickAddToBasket()
        .clickSaleItem();

    homePage.clickToCart();

    cartPage.clickProceedToCheckout();

    checkoutPage.verifyCheckoutUrl(CHECKOUT_PAGE)
      .verifyVisibleElements()
      .typeFirstName(FIRST_NAME)
      .typeLastName(LAST_NAME)
      .typeCompanyName(COMPANY)
      .typeEmail(EMAIL)
      .typePhone(PHONE)
      .typeAddress(ADDRESS)
      .typeApartment(APARTMENT)
      .typeCity(CITY)
      .typeState(STATE)
      .typePostcode(ZIP)
      .clickPlaceOrder();


    orderPage.waitLoadingPage()
      .verifyOrderUrl(ORDER_PAGE);
  }
}
