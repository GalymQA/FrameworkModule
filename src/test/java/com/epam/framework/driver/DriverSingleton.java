package com.epam.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String HEADLESS = "--headless";
    private static final String DISABLE_GPU = "--disable-gpu";
    private static final String WINDOW_SIZE = "--window-size=1580,1280";

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if ("firefox".equals(System.getProperty("browser"))) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments(HEADLESS);
                options.addArguments(DISABLE_GPU);
                options.addArguments(WINDOW_SIZE);
                driver = new FirefoxDriver(options);
            }
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(HEADLESS);
            options.addArguments(DISABLE_GPU);
            options.addArguments(WINDOW_SIZE);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
