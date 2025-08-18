package de.ebay.fw;

import de.ebay.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectHelper extends BaseHelper {

    public SelectHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnDepartmentLink(String department) {
        click(By.cssSelector("#vl-flyout-nav>ul>li:nth-child(" + department + ")"));
    }

    public void clickOnSection(String section) {
        click(By.cssSelector(".seoel__item:nth-child(" + section + ")"));
    }

    public void clickOnBrand(String brand) {
        click(By.xpath("//ul[@class='seoel__items']//span[.='" + brand + "']"));
    }
}
