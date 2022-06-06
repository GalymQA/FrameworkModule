package com.epam.framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResultsPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/s/";
    private final Logger logger = LogManager.getRootLogger();

    private final By linkPricingCalculatorLocator = By.xpath(
            "//div[@class='gs-title'] //a[@class='gs-title'] //b[text()='Google Cloud Platform Pricing Calculator']");

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleSearchResultsPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Opened Google search results page");
        return this;
    }

    public GoogleCalculatorPage clickPricingCalculatorLink() {
        WebElement linkPricingCalculator = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(linkPricingCalculatorLocator));
        linkPricingCalculator.click();
        logger.info("Clicked on the calculator");
        return new GoogleCalculatorPage(driver);
    }

}
