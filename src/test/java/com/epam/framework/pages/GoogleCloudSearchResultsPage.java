package com.epam.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudSearchResultsPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/s/";

    @FindBy(xpath = "//div[@class='gs-title']/a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement linkPricingCalculator;

    @Override
    public GoogleCloudSearchResultsPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPricingCalculatorPage clickPricingCalculatorLink() throws InterruptedException {
        linkPricingCalculator.click();
        Thread.sleep(5000);
        return new GoogleCloudPricingCalculatorPage(driver);
    }

}
