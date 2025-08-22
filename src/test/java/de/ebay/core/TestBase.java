package de.ebay.core;

import de.ebay.utils.MyTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({MyTestListener.class})
public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }


}
