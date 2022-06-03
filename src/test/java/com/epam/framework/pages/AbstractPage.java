package com.epam.framework.pages;

import org.openqa.selenium.WebDriver;

abstract class AbstractPage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final int WAIT_SECONDS_AFTER_CLICK = 1;
    protected final int MAX_NUMBER_OF_CLICKS = 20;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

}
