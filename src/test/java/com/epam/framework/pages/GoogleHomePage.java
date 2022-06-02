package com.epam.framework.pages;

import com.epam.framework.model.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(css = "input[name='q']")
    private WebElement inputSearch;

    @FindBy(css = "form[class='devsite-search-form']")
    private WebElement formSearch;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleHomePage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleSearchResultsPage enterSearchText(TestData testData) {
        inputSearch.click();
        inputSearch.sendKeys(testData.getSearchInputText());
        formSearch.submit();
        return new GoogleSearchResultsPage(driver);
    }

}
