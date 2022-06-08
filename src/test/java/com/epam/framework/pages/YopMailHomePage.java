package com.epam.framework.pages;

import com.epam.framework.model.YopMailAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailHomePage extends AbstractPage {

    private final String BASE_URL = "https://yopmail.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "login")
    private WebElement inputForEmailAccount;

    @FindBy(id = "refreshbut")
    private WebElement buttonProceedToInbox;

    public YopMailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public YopMailHomePage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Opened YOP mail home page");
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public YopMailInboxPage createEmailAccount(YopMailAccount yopMailAccount) {
        inputForEmailAccount.click();
        inputForEmailAccount.sendKeys(yopMailAccount.getEmailAccount());
        buttonProceedToInbox.click();
        logger.info("Created a new account at YOP mail");
        return new YopMailInboxPage(driver);
    }

}
