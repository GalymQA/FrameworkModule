package com.epam.framework.pages;

import com.epam.framework.model.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailHomePage extends AbstractPage {

    private final String BASE_URL = "https://yopmail.com/";

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
        return this;
    }

    public YopMailInboxPage createEmailAccount(TestData testData) {
        inputForEmailAccount.click();
        inputForEmailAccount.sendKeys(testData.getEmailAccount());
        buttonProceedToInbox.click();
        return new YopMailInboxPage(driver);
    }

}
