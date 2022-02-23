package tests.home;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.*;
import static constants.Constants.VerifyVariable.*;

public class HomeAddToBasketItemsCoupon extends BaseTest {

  @Test
  public void ShouldArrivalsAddToBasketCoupon() {
    basePage.open(HOME_PAGE);

    homePage.clickShopBtn();

    listsPage.clickHomeBtn();

    homePage.verifyCountArrival(ARRIVALS_LENGTH)
      .clickLastArrivalLink();

    itemPage.verifyItemUrl(SOME_PRODUCT_PAGE)
      .typeValueCountInput(COUNT_BOOKS)
      .clickToBasketBtn();

    homePage.verifyCartContentsNotEquals(COUNT_ZERO)
      .clickToCart();

    cartPage.verifyCartUrl(CART_PAGE)
      .typeCoupon(COUPON)
      .clickApplyCoupon()
      .verifyAddCoupon();
  }
}
