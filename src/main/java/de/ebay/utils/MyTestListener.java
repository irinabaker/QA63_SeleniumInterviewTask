package de.ebay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    Logger logger = LoggerFactory.getLogger(MyTestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test PASSED: {}",result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test FAILED: {}",result.getMethod().getMethodName());
        logger.error("Reason: {}",result.getThrowable());
    }
}
