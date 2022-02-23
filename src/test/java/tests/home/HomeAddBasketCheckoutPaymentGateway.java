package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.BillingDetails.*;
import static constants.Constants.Urls.*;
import static constants.Constants.Urls.CHECKOUT_PAGE;
import static constants.Constants.VerifyVariable.*;

public class HomeAddBasketCheckoutPaymentGateway extends BaseTest {

  @Test
  public void ShouldAddBasketPaymentGateway() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickHomeBtn();

    homePage.verifyCountArrival(ARRIVALS_LENGTH)
      .clickLastArrivalLink();

    itemPage.verifyItemUrl(SOME_PRODUCT_PAGE)
      .clickToBasketBtn();

    homePage.verifyCartContentsNotEquals(COUNT_ZERO)
      .clickToCart();

    cartPage.verifyCartUrl(CART_PAGE)
      .typeCountBooks(COUNT_BOOKS)
      .clickUpdateBasket()
      .verifyUpdateMessage()
      .verifySubtotalLessTotal()
      .clickProceedToCheckout();

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
