package com.epam.framework.pages;

import com.epam.framework.model.TestData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GoogleCalculatorPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tab-item //div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement sectionComputeEngine;

    @FindBy(xpath = "//iframe[contains(@src, 'https://cloud.google.com/products/calculator')]")
    private WebElement iFramePricingCalculator;

    @FindBy(xpath = "//iframe[@id = 'myFrame']")
    private WebElement iFrameMyFrame;

    @FindBy(id = "input_86")
    private WebElement optionsForNumberOfInstances;

    @FindBy(css = "md-select[id='select_99']")
    private WebElement optionsForOperatingSystem;

    @FindBy(css = "md-select[id='select_103']")
    private WebElement optionsForVMClass;

    @FindBy(css = "md-select[id='select_111']")
    private WebElement optionsForSeries;

    @FindBy(css = "md-select[id=select_113]")
    private WebElement optionsForInstanceType;

    @FindBy(xpath = "//form[@name='ComputeEngineForm'] //md-checkbox[@aria-label='Add GPUs' and @aria-disabled='false' and @aria-checked='false']")
    private WebElement checkboxAddGPUs;

    @FindBy(css = "md-select[id='select_449']")
    private WebElement optionsForGPUType;

    @FindBy(css = "md-select[id='select_451']")
    private WebElement optionsForNumberOfGPUs;

    @FindBy(css = "md-select[id='select_410']")
    private WebElement optionsForLocalSSD;

    @FindBy(css = "md-select[id='select_121']")
    private WebElement optionsForDataCenterLocation;

    @FindBy(css = "md-select[id='select_128']")
    private WebElement optionsForCommittedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm'] //button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimateInComputeEngineForm;

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement buttonSendEmail;

    private final By emailInputLocator = By.cssSelector("input[ng-model='emailQuote.user.email']");
    private final By buttonEmailEstimateLocator = By.id("email_quote");

    public GoogleCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleCalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleCalculatorPage chooseSectionComputeEngine() {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        sectionComputeEngine.click();
        return this;
    }

    public GoogleCalculatorPage enterNumberOfInstances(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForNumberOfInstances.sendKeys(testData.getNumberOfInstances());
        return this;
    }

    public GoogleCalculatorPage enterOperatingSystem(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForOperatingSystem.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", testData.getOperatingSystem());
        WebElement optionFreeOperatingSystem = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionFreeOperatingSystem.click();
        return this;
    }

    public GoogleCalculatorPage enterVirtualMachineClass(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForVMClass.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", testData.getVirtualMachineClass());
        WebElement optionRegularVMClass = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionRegularVMClass.click();
        return this;
    }

    public GoogleCalculatorPage enterSeries(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForSeries.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", testData.getInstanceSeries());
        WebElement optionInstanceSeries = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionInstanceSeries.click();
        return this;
    }

    public GoogleCalculatorPage enterInstanceType(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForInstanceType.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", testData.getInstanceType());
        WebElement optionInstanceType = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionInstanceType.click();
        return this;
    }

    public GoogleCalculatorPage checkAddGPUsCheckbox() {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        checkboxAddGPUs.click();
        return this;
    }

    public GoogleCalculatorPage enterGPUType(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForGPUType.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", testData.getGPUType());
        WebElement optionGPUType = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionGPUType.click();
        return this;
    }

    public GoogleCalculatorPage enterNumberOfGPUs(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForNumberOfGPUs.click();
        String xpathString = String.format("//div[@id='select_container_452'] //md-option //div[contains(text(),'%s')]",
                testData.getNumberGPUs());
        WebElement optionNumberGPUs = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionNumberGPUs.click();
        return this;
    }

    public GoogleCalculatorPage enterLocalSSD(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForLocalSSD.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", testData.getLocalSSD());
        WebElement optionLocalSSD = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionLocalSSD.click();
        return this;
    }

    public GoogleCalculatorPage enterDataCenterLocation(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForDataCenterLocation.click();
        String xpathString = String.format("//div[@id='select_container_122'] //md-option //div[contains(text(),'%s')]",
                testData.getDatacenterLocation());
        WebElement optionDatacenterLocation = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionDatacenterLocation.click();
        return this;
    }

    public GoogleCalculatorPage enterCommittedUsage(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForCommittedUsage.click();
        String xpathString = String.format("//div[@id='select_container_129'] //md-option //div[contains(text(),'%s')]",
                testData.getCommittedUsage());
        WebElement optionCommittedUsage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionCommittedUsage.click();
        return this;
    }

    public GoogleCalculatorPage requestFormToSendEstimates(TestData testData) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        buttonAddToEstimateInComputeEngineForm.click();
        WebElement buttonEmailEstimate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buttonEmailEstimateLocator));
        buttonEmailEstimate.click();
        return this;
    }

    public YopMailHomePage createYopMailTabAndSwitch() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new YopMailHomePage(driver);
    }

    public GoogleCalculatorPage sendPricingToEmail(String emailName) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        WebElement emailInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
        emailInput.sendKeys(emailName);
        buttonSendEmail.click();
        return this;
    }

    public YopMailInboxPage switchToYopMailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new YopMailInboxPage(driver);
    }

    public String getTotalCostInCalculator() {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        WebElement totalCostWebElement = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='md-title'] b")));
        String totalCost = totalCostWebElement.getText();
        totalCost = totalCost.replaceAll("Total Estimated Cost", "")
                .replaceAll("USD", "")
                .replaceAll("per 1 month", "")
                .replaceAll(":", "")
                .replaceAll("\\s+", "");
        return totalCost;
    }

}
