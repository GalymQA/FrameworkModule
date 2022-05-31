package com.epam.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class YopMailInboxPage extends AbstractPage {

    private final String BASE_URL = "https://yopmail.com/";

    @FindBy(css = "div[class='bname']")
    private WebElement sectionForEmailAccountName;

    public YopMailInboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public YopMailInboxPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getCreatedEmail() {
        return sectionForEmailAccountName.getText();
    }

    public GoogleCloudPricingCalculatorPage switchToGoogleCloudPricingCalculatorTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new GoogleCloudPricingCalculatorPage(driver);
    }

}
