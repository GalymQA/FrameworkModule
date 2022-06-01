package com.epam.framework.pages;

import com.epam.framework.model.SearchInput;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tab-item //div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement sectionComputeEngine;

    @FindBy(xpath = "//iframe[contains(@src, 'https://cloud.google.com/products/calculator')]")
    private WebElement iFramePricingCalculator;

    @FindBy(xpath = "//iframe[@id = 'myFrame']")
    private WebElement iFrameMyFrame;



    private final By sectionComputeEngineLocator = By.xpath("//md-tab-item //div[@title='Compute Engine' and @class='tab-holder compute']");

    @FindBy(id = "input_86")
    private WebElement optionsForNumberOfInstances;

    @FindBy(css = "md-select[id='select_99']")
    private WebElement optionsForOperatingSystem;



    @FindBy(css = "md-option[id='select_option_88']")
    private WebElement optionFreeOperatingSystem;

    private final By optionFreeOperatingSystemLocator = By.cssSelector("md-option[id='select_option_88']");

    @FindBy(css = "md-select[id='select_103']")
    private WebElement optionsForVMClass;


    @FindBy(css = "md-option[value='regular']")
    private WebElement optionRegularVMClass;

    private final By optionRegularVMClassLocator = By.cssSelector("md-option[value='regular']");

    @FindBy(css = "md-select[id='select_111']")
    private WebElement optionsForSeries;

    private final By optionN1SeriesLocator = By.cssSelector("md-option[id='select_option_198']");

    @FindBy(css = "md-select[id=select_113]")
    private WebElement optionsForMachineType;

    private final By optionN1Standard8Locator = By.cssSelector("md-option[id=select_option_415]");

    @FindBy(xpath = "//form[@name='ComputeEngineForm'] //md-checkbox[@aria-label='Add GPUs' and @aria-disabled='false' and @aria-checked='false']")
    private WebElement checkboxAddGPUs;

    @FindBy(css = "md-select[id='select_449']")
    private WebElement optionsForGPUType;

    private final By optionNvidiaTeslaP100Locator = By.cssSelector("md-option[value='NVIDIA_TESLA_P100']");

    @FindBy(css = "md-select[id='select_451']")
    private WebElement optionsForNumberOfGPUs;

    private final By optionOneGPULocator = By.cssSelector("md-option[id='select_option_460']");

    @FindBy(css = "md-select[id='select_410']")
    private WebElement optionsForLocalSSD;

    private final By optionLocalSSD2x375GbLocator = By.cssSelector("md-option[id='select_option_436']");

    @FindBy(css = "md-select[id='select_121']")
    private WebElement optionsForDataCenterLocation;

    private final By optionFrankfurtDataCenterLocator = By.cssSelector("md-option[id='select_option_222']");

    @FindBy(css = "md-select[id='select_128']")
    private WebElement optionsForCommittedUsage;

    private final By optionForCommittedUsageOneYearLocator = By.cssSelector("md-option[id='select_option_126']");

    @FindBy(xpath = "//form[@name='ComputeEngineForm'] //button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimateInComputeEngineForm;

    @FindBy(id = "email_quote")
    private WebElement buttonEmailEstimate;

    private final By buttonEmailEstimateLocator = By.id("email_quote");

    @FindBy(css = "input[ng-model='emailQuote.user.email']")
    private WebElement emailInput;

    private final By emailInputLocator = By.cssSelector("input[id='input_513']");

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement buttonSendEmail;




    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleCloudPricingCalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseSectionComputeEngine() {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        sectionComputeEngine.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterNumberOfInstances(SearchInput searchInput) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForNumberOfInstances.sendKeys(searchInput.getNumberOfInstances());
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterOperatingSystem(SearchInput searchInput) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForOperatingSystem.click();
        WebElement optionFreeOperatingSystem = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionFreeOperatingSystemLocator));
        optionFreeOperatingSystem.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterVMClass(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForVMClass.click();
        WebElement optionRegularVMClass = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionRegularVMClassLocator));
        optionRegularVMClass.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterSeries(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForSeries.click();
        WebElement optionN1Series = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionN1SeriesLocator));
        optionN1Series.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterMachineType(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForMachineType.click();
        WebElement optionN1Standard8 = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionN1Standard8Locator));
        optionN1Standard8.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage checkAddGPUsCheckbox() throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        checkboxAddGPUs.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterGPUType(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForGPUType.click();
        WebElement optionNvidiaTeslaP100 = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionNvidiaTeslaP100Locator));
        optionNvidiaTeslaP100.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterNumberOfGPUs(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForNumberOfGPUs.click();
        WebElement optionOneGPU = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionOneGPULocator));
        optionOneGPU.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterLocalSSD(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForLocalSSD.click();
        WebElement optionLocalSSD2x375Gb = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionLocalSSD2x375GbLocator));
        optionLocalSSD2x375Gb.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterDataCenterLocation(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForDataCenterLocation.click();
        WebElement optionFrankfurtDataCenter = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionFrankfurtDataCenterLocator));
        optionFrankfurtDataCenter.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterCommittedUsage(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForCommittedUsage.click();
        WebElement optionForCommittedUsageOneYear = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionForCommittedUsageOneYearLocator));
        optionForCommittedUsageOneYear.click();
        Thread.sleep(2000);
        return this;
    }

    public GoogleCloudPricingCalculatorPage requestFormToSendEstimates(SearchInput searchInput) throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        buttonAddToEstimateInComputeEngineForm.click();
        WebElement buttonEmailEstimate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buttonEmailEstimateLocator));
        buttonEmailEstimate.click();
        Thread.sleep(5000);
        return this;
    }

    public YopMailHomePage switchToNewlyCreatedYopMailTab() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new YopMailHomePage(driver);
    }

    public GoogleCloudPricingCalculatorPage sendPricingToEmail(String email) throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        emailInput.sendKeys(email);
        buttonSendEmail.click();
        Thread.sleep(3000);
        return this;
    }

    public YopMailInboxPage switchToYopMailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new YopMailInboxPage(driver);
    }

    public String getTotalCostInCalculator() {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        String totalCostInCalculator = driver.findElement(By.cssSelector("h2[class='md-title'] b")).getText();
        totalCostInCalculator = totalCostInCalculator.replaceAll("Total Estimated Cost", "")
                .replaceAll("USD","")
                .replaceAll("per 1 month", "")
                .replaceAll(":", "")
                .replaceAll("\\s+", "");
        return totalCostInCalculator;
    }


}
