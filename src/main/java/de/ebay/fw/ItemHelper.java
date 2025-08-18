package de.ebay.fw;

import de.ebay.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public String getItemName(String number) {
        return driver
                .findElement(By.cssSelector(".brwrvr__item-card:nth-child(" + number + ") .bsig__title__text")).getText();
    }

    public void enterItemToSearchBar(String itemName) {
        type(By.id("gh-ac"),itemName);
        click(By.id("gh-search-btn"));
    }

    public String getFirstItemName() {
        return driver.findElement().getText();
    }
}
