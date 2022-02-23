package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.*;
import static constants.Constants.VerifyVariable.*;

public class HomeAddBasketAndUpdateBasket extends BaseTest {

  @Test
  public void ShouldAddBasketItemsAndAddBook() {
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
      .verifyTotalPrice();
  }
}
