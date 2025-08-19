package de.ebay.core;

import de.ebay.fw.ItemHelper;
import de.ebay.fw.SelectHelper;
import de.ebay.utils.MyListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    SelectHelper select;
    ItemHelper item;

    public void init() {
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.de");

        select = new SelectHelper(driver);
        item = new ItemHelper(driver);
    }

    public SelectHelper getSelect() {
        return select;
    }

    public ItemHelper getItem() {
        return item;
    }

    public void stop() {
        driver.quit();
    }
}
