package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItemPage extends BasePage {
  public ItemPage(WebDriver driver) {
    super(driver);
  }

  private final By descriptionTab = By.className("description_tab");
  private final By descriptionContent = By.id("tab-description");
  private final By reviewsTab = By.className("reviews_tab");
  private final By reviewsContent = By.id("reviews");
  private final By addToBasketBtn = By.className("single_add_to_cart_button");
  private final By countInput = By.xpath("//div[@class='quantity']/input");
  private final By oldPrice = By.xpath("//p[@class='price']/del");
  private final By newPrice = By.xpath("//p[@class='price']/ins");

  public ItemPage verifyItemUrl(String url) {
    String URL = driver.getCurrentUrl();
    Assert.assertTrue(URL.contains(url));
    return this;
  }

  public ItemPage clickDescription() {
    WebElement description = driver.findElement(descriptionTab);
    waitElementIsVisible(description).click();
    return this;
  }

  public ItemPage verifyDescription() {
    waitElementIsVisible(driver.findElement(descriptionContent));
    return this;
  }

  public ItemPage clickReviews() {
    WebElement reviews = driver.findElement(reviewsTab);
    waitElementIsVisible(reviews).click();
    return this;
  }

  public ItemPage verifyReviews() {
    waitElementIsVisible(driver.findElement(reviewsContent));
    return this;
  }

  public ItemPage clickToBasketBtn() {
    WebElement basketBtn = driver.findElement(addToBasketBtn);
    waitElementIsVisible(basketBtn).click();
    return this;
  }

  public ItemPage typeMaxValueCountInput() {
    WebElement countInp = driver.findElement(countInput);
    String maxValueStr = countInp.getAttribute("max");
    int moreMaxValue = Integer.parseInt(maxValueStr) + 1;
    countInp.click();
    countInp.clear();
    countInp.sendKeys(String.valueOf(moreMaxValue));
    return this;
  }

  public ItemPage typeValueCountInput(String count) {
    WebElement countInp = driver.findElement(countInput);
    countInp.click();
    countInp.clear();
    countInp.sendKeys(String.valueOf(count));
    return this;
  }

  public ItemPage verifyNewAndOldPrice() {
    WebElement newPriceSpan = driver.findElement(newPrice);
    WebElement oldPriceSpan = driver.findElement(oldPrice);
    waitElementIsVisible(newPriceSpan);
    waitElementIsVisible(oldPriceSpan);
    return this;
  }
}
