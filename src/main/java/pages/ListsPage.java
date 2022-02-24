package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListsPage extends BasePage {
  public ListsPage(WebDriver driver) {
    super(driver);
  }

  public final By homeBtn = By.xpath("//a[@title='Automation Practice Site']");
  public final By itemLists = By.xpath("//h3[contains(text(), 'Selenium Ruby')]");

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
}
