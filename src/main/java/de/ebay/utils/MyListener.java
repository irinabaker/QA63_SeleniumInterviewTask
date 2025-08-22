package de.ebay.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("The test has a problem!!!");
        logger.info("*******************************");
        logger.error("Method -> {}",method.getName());
        logger.info("*********************************");
        logger.error("Object target -> {}",target);
        logger.info("********************************");
        logger.error("Target exception -> {}",e.getCause());
        logger.info("**********************************");

        WebDriver driver = (FirefoxDriver)target;

        int i = new Random().nextInt(1000);
        String link = "screenshots/screen_" + i + ".png";
        logger.info("Screen with error --> {}",link);

        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
       logger.info("We will open web site {}",url);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Element with locator {} found",locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("Elements with locators {} found",locator);
        logger.info("List of element size is {}", result.size());
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("{}",element.getText());
    }
}
