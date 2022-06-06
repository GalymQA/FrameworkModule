package com.epam.framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YopMailInboxPage extends AbstractPage {

    private final String BASE_URL = "https://yopmail.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(css = "div[class='bname']")
    private WebElement sectionForEmailAccountName;

    @FindBy(css = "iframe[id='ifmail']")
    private WebElement iFrameEmailContent;

    @FindBy(css = "iframe[id='ifinbox']")
    private WebElement iFrameInbox;

    @FindBy(css = "div[class='m'] input[type='checkbox']")
    private List<WebElement> checkboxesInEmails;

    @FindBy(id = "refresh")
    private WebElement buttonRefresh;

    @FindBy(css = "button[class='lm']")
    private WebElement singleEmailAfterDelete;

    @FindBy(id = "delsel")
    private WebElement buttonDelete;

    private final By checkboxesInEmailsLocator = By.cssSelector("div[class='m'] input[type='checkbox']");
    private final By buttonRefreshLocator = By.cssSelector("button[id='refresh']");
    private final By singleEmailTotalCostLocator = By.cssSelector("tbody h2");

    public YopMailInboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public YopMailInboxPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Opened YOP mail inbox page");
        return this;
    }

    public String getCreatedEmailName() {
        logger.info("Got the created email name");
        return sectionForEmailAccountName.getText();
    }

    public YopMailInboxPage deleteAllEmailsInInbox() {
        driver.switchTo().defaultContent();
        WebElement buttonRefresh = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buttonRefreshLocator));
        buttonRefresh.click();
        driver.switchTo().defaultContent().switchTo().frame(iFrameInbox);
        for (WebElement checkbox : checkboxesInEmails) {
            checkbox.click();
        }
        driver.switchTo().defaultContent();
        buttonDelete.click();
        driver.switchTo().defaultContent().switchTo().frame(iFrameInbox);
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.numberOfElementsToBe(checkboxesInEmailsLocator, 0));
        logger.info("Deleted all emails in YOP mail inbox");
        return this;
    }

    public String getTotalCostInEmail() throws InterruptedException {
        driver.switchTo().defaultContent().switchTo().frame(iFrameInbox);
        int numberOfClicks = 0;
        while (checkboxesInEmails.size() == 0) {
            driver.switchTo().defaultContent();
            buttonRefresh.click();
            Thread.sleep(TimeUnit.SECONDS.toMillis(WAIT_SECONDS_AFTER_CLICK));
            driver.switchTo().defaultContent().switchTo().frame(iFrameInbox);
            if (++numberOfClicks >= MAX_NUMBER_OF_CLICKS) {
                break;
            }
        }
        driver.switchTo().defaultContent().switchTo().frame(iFrameInbox);
        singleEmailAfterDelete.click();
        driver.switchTo().defaultContent().switchTo().frame(iFrameEmailContent);
        WebElement singleEmailBody = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(singleEmailTotalCostLocator));
        logger.info("Got the total cost from the delivered email");
        return getNumericPart(singleEmailBody.getText());
    }

    private String getNumericPart(String string) {
        return string.replaceAll("Estimated Monthly Cost: USD ", "");
    }

}
