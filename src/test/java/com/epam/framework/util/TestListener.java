package com.epam.framework.util;

import com.epam.framework.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private Logger log = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.error("Started a test");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.error("The test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
        log.error("Saved screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.error("Skipped a test");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.error("Test failed but within success percentage rate");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.error("Started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.error("Finished");
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

}
