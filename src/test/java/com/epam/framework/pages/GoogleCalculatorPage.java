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

    @FindBy(css = "input[ng-model='listingCtrl.computeServer.quantity']")
    private WebElement optionsForNumberOfInstances;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.os']")
    private WebElement optionsForOperatingSystem;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.class']")
    private WebElement optionsForVMClass;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.series']")
    private WebElement optionsForSeries;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.instance']")
    private WebElement optionsForInstanceType;

    @FindBy(css = "md-checkbox[ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement checkboxAddGPUs;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.ssd']")
    private WebElement optionsForLocalSSD;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.location']")
    private WebElement optionsForDataCenterLocation;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.cud']")
    private WebElement optionsForCommittedUsage;

    @FindBy(css = "button[ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement buttonAddToEstimateInComputeEngineForm;

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement buttonSendEmail;

    private final By optionsForGPUTypeLocator =
            By.cssSelector("md-select[ng-model='listingCtrl.computeServer.gpuType']");
    private final By optionsForGPUCountLocator =
            By.cssSelector("md-select[ng-model='listingCtrl.computeServer.gpuCount']");
    private final By emailInputLocator =
            By.cssSelector("input[ng-model='emailQuote.user.email']");
    private final By buttonEmailEstimateLocator = By.id("email_quote");
    private final By totalEstimatedCostLocator =
            By.cssSelector("h2[class='md-title'] b");


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
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]",
                pricingInputs.getOperatingSystem());
        WebElement optionFreeOperatingSystem = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionFreeOperatingSystem.click();
        return this;
    }

    public GoogleCalculatorPage enterVirtualMachineClass(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForVMClass.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]",
                pricingInputs.getVirtualMachineClass());
        WebElement optionRegularVMClass = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionRegularVMClass.click();
        return this;
    }

    public GoogleCalculatorPage enterSeries(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForSeries.click();
        String xpathString = String.format("//md-option //div[contains(text(),'%s')]",
                pricingInputs.getInstanceSeries());
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
                .until(ExpectedConditions.elementToBeClickable(optionsForGPUCountLocator));
        optionsForNumberOfGPUs.click();
        String xpathString = String.format("//md-option[" +
                        "contains(@ng-repeat, 'listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]')]" +
                        " //div[contains(text(),'%s')]",
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
        String xpathString = String.format("//md-option[" +
                        "@ng-repeat='item in listingCtrl.fullRegionList | " +
                        "filter:listingCtrl.inputRegionText.computeServer'] " +
                        "//div[contains(text(),'%s')]",
                        pricingInputs.getDatacenterLocation());
        WebElement optionDatacenterLocation = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
        optionDatacenterLocation.click();
        return this;
    }

    public GoogleCalculatorPage enterCommittedUsage(PricingInputs pricingInputs) {
        driver.switchTo().defaultContent().switchTo().frame(iFramePricingCalculator).switchTo().frame(iFrameMyFrame);
        optionsForCommittedUsage.click();
        String xpathString = String.format(
                "//div[@class='md-select-menu-container md-active md-clickable'] //div[contains(text(),'%s')]",
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
                .until(ExpectedConditions.visibilityOfElementLocated(totalEstimatedCostLocator));
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
