package com.epam.framework.pages;

import org.openqa.selenium.By;
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

    @FindBy(css = "iframe[id='ifmail']")
    private WebElement iFrameEmailContent;

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
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    public String getTotalCostInEmail() {
        driver.switchTo().defaultContent().switchTo().frame(iFrameEmailContent);
        String totalCost = driver.findElements(By.cssSelector("h3")).get(1).getText();
        totalCost = totalCost.replaceAll("USD ", "");
        return totalCost;
    }


}
