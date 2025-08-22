package de.ebay.tests;

import de.ebay.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void searchItemPositiveTest() {
        app.getSelect().clickOnDepartmentLink("2");
        app.getSelect().clickOnSection("1");
        app.getSelect().clickOnBrand("Apple");
        String neededItemName = app.getItem().getItemName("2");
       // System.out.println(neededItemName);
        app.getItem().enterItemToSearchBar(neededItemName);
        String firstItemName = app.getItem().getFirstItemName();
       // System.out.println(firstItemName);
       Assert.assertTrue(firstItemName.contains(neededItemName));
    }
}

/*
Get ‘Elektronik’
Select section ‘Handys & Smartphones’
Select ‘Apple’
Remember second element in search results
Enter the memorized value in the search bar
Find and check that the product name matches the stored value
*/

