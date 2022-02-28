package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ListsPage extends BasePage {
  public ListsPage(WebDriver driver) {
    super(driver);
  }

  private final By homeBtn = By.xpath("//a[@title='Automation Practice Site']");
  private final By itemLists = By.xpath("//h3[contains(text(), 'Selenium Ruby')]");
  private final By sliderRight = By.xpath("(//div[contains(@class, 'price_slider')]/span)[last()]");
  private final By filter = By.xpath("//div[contains(@class, 'price_slider')]/button");
  private final By normalPrice = By.xpath("//span[@class='price']/span");
  private final By priceWithSale = By.xpath("//span[@class='price']/ins/span");
  private final By categories = By.xpath("//ul[@class='product-categories']/li/a");
  private final By sorting = By.className("orderby");
  private final By readMore = By.xpath("//a[text()='Read more']");
  private final By outOfStock = By.xpath("//p[text()='Out of stock']");
  private final By addToBasket = By.xpath("//a[text()='Add to basket']");
  private final By cartContents = By.className("cartcontents");


  public ListsPage clickHomeBtn() {
    WebElement homeBtnFind = driver.findElement(homeBtn);
    waitElementIsVisible(homeBtnFind).click();
    return this;
  }

  public ListsPage clickItem() {
    WebElement firstItemList = driver.findElement(itemLists);
    waitElementIsVisible(firstItemList).click();
    return this;
  }

  public ListsPage changeRightSlider(int val) {
    WebElement sliderRightSpan = driver.findElement(sliderRight);
    waitElementIsVisible(sliderRightSpan);
    Actions actions = new Actions(driver);
    actions.clickAndHold(sliderRightSpan);
    for (int i = 0; i < 500 - val; i++) {
      sliderRightSpan.sendKeys(Keys.ARROW_LEFT);
    }
    return this;
  }

  public ListsPage clickFilter() {
    WebElement filterBtn = driver.findElement(filter);
    waitElementIsVisible(filterBtn).click();
    return this;
  }

  public ListsPage verifyFilterPrices(int val) {
    List<WebElement> allNormalPrices = driver.findElements(normalPrice);
    List<WebElement> allSalePrices = driver.findElements(priceWithSale);
    List<WebElement> allPrices = new ArrayList<>(allNormalPrices);
    allPrices.addAll(allSalePrices);
    for (int i = 0; i < allPrices.size(); i++) {
      float elementsFloat = Float.parseFloat(allPrices.get(i).getText().replaceAll("[^0-9.]", ""));
      Assert.assertTrue(elementsFloat <= val);
    }
    return this;
  }

  public ListsPage clickSomeCategory(int position) {
    List<WebElement> categoryLink = driver.findElements(categories);
    categoryLink.get(position).click();
    return this;
  }

  public ListsPage verifyCategoryUrl(int position) {
    List<WebElement> categoryLink = driver.findElements(categories);
    String strUrl = driver.getCurrentUrl();
    String categoryText = categoryLink.get(position).getText().toLowerCase();
    Assert.assertTrue(strUrl.contains(categoryText));
    return this;
  }

  public ListsPage selectSorting(String val) {
    Select sortingSelect = new Select(driver.findElement(sorting));
    sortingSelect.selectByValue(val);
    return this;
  }

  public ListsPage verifySelectSort(String val) {
    String strUrl = driver.getCurrentUrl();
    Assert.assertTrue(strUrl.contains(val));
    return this;
  }

  public ListsPage clickReadMore() {
    WebElement readMoreBtn = driver.findElement(readMore);
    waitElementIsVisible(readMoreBtn).click();
    return this;
  }

  public ListsPage clickAddToBasket() {
    WebElement addToBasketBtn = driver.findElement(addToBasket);
    waitElementIsVisible(addToBasketBtn).click();
    return this;
  }

  public ListsPage verifyOutOfStock() {
    WebElement outOfStockP = driver.findElement(outOfStock);
    waitElementIsVisible(outOfStockP);
    return this;
  }

  public ListsPage clickSaleItem() {
    WebElement saleItem = driver.findElement(priceWithSale);
    waitElementIsVisible(saleItem).click();
    return this;
  }

}
