package com.epam.framework.pages;

import com.epam.framework.model.PricingInputs;
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

    @FindBy(id = "select_value_label_77")
    private WebElement optionsForOperatingSystem;

    @FindBy(id = "select_value_label_78")
    private WebElement optionsForVMClass;

    @FindBy(id = "select_value_label_80")
    private WebElement optionsForSeries;

    @FindBy(id = "select_value_label_81")
    private WebElement optionsForInstanceType;

    @FindBy(xpath = "//form[@name='ComputeEngineForm'] //md-checkbox[@aria-label='Add GPUs' and @aria-disabled='false' and @aria-checked='false']")
    private WebElement checkboxAddGPUs;

    @FindBy(id = "select_value_label_409")
    private WebElement optionsForLocalSSD;

    @FindBy(id = "select_value_label_84")
    private WebElement optionsForDataCenterLocation;

    @FindBy(id = "select_value_label_85")
    private WebElement optionsForCommittedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm'] //button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimateInComputeEngineForm;

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement buttonSendEmail;

    private final By optionsForGPUTypeLocator = By.cssSelector("md-select[placeholder='GPU type']");
    private final By optionsForNumberOfGPUsLocator = By.cssSelector("md-select[placeholder='Number of GPUs']");
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

    public GoogleCalculatorPage enterNumberOfInstances(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForNumberOfInstances.sendKeys(pricingInputs.getNumberOfInstances());
        return this;
    }

    public GoogleCalculatorPage enterOperatingSystem(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForOperatingSystem.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", pricingInputs.getOperatingSystem());
        WebElement optionFreeOperatingSystem = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionFreeOperatingSystem.click();
        return this;
    }

    public GoogleCalculatorPage enterVirtualMachineClass(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForVMClass.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", pricingInputs.getVirtualMachineClass());
        WebElement optionRegularVMClass = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionRegularVMClass.click();
        return this;
    }

    public GoogleCalculatorPage enterSeries(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForSeries.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", pricingInputs.getInstanceSeries());
        WebElement optionInstanceSeries = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionInstanceSeries.click();
        return this;
    }

    public GoogleCalculatorPage enterInstanceType(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForInstanceType.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", pricingInputs.getInstanceType());
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

    public GoogleCalculatorPage enterGPUType(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        WebElement optionsForGPUType = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionsForGPUTypeLocator));
        optionsForGPUType.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", pricingInputs.getGPUType());
        WebElement optionGPUType = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionGPUType.click();
        return this;
    }

    public GoogleCalculatorPage enterNumberOfGPUs(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        WebElement optionsForNumberOfGPUs = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionsForNumberOfGPUsLocator));
        optionsForNumberOfGPUs.click();
        String xpathString = String.format("//div[@id='select_container_452'] //md-option //div[contains(text(),'%s')]",
                pricingInputs.getNumberGPUs());
        WebElement optionNumberGPUs = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionNumberGPUs.click();
        return this;
    }

    public GoogleCalculatorPage enterLocalSSD(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForLocalSSD.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]", pricingInputs.getLocalSSD());
        WebElement optionLocalSSD = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionLocalSSD.click();
        return this;
    }

    public GoogleCalculatorPage enterDataCenterLocation(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForDataCenterLocation.click();
        String xpathString = String.format("//div[@id='select_container_122'] //md-option //div[contains(text(),'%s')]",
                pricingInputs.getDatacenterLocation());
        WebElement optionDatacenterLocation = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionDatacenterLocation.click();
        return this;
    }

    public GoogleCalculatorPage enterCommittedUsage(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForCommittedUsage.click();
        String xpathString = String.format("//div[@id='select_container_129'] //md-option //div[contains(text(),'%s')]",
                pricingInputs.getCommittedUsage());
        WebElement optionCommittedUsage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionCommittedUsage.click();
        return this;
    }

    public GoogleCalculatorPage requestFormToSendEstimates() {
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
        return getNumericPart(totalCostWebElement.getText());
    }

    private String getNumericPart(String string) {
        return string.replaceAll("Total Estimated Cost", "")
                .replaceAll("USD", "")
                .replaceAll("per 1 month", "")
                .replaceAll(":", "")
                .replaceAll("\\s+", "");
    }

}
