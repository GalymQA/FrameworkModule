package com.epam.framework.pages;

import com.epam.framework.model.SearchInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src/test/resources/testng-all.xml -Denvironment=dev clean test

public class GoogleCloudHomePage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(css = "input[name='q']")
    private WebElement inputSearch;

    @FindBy(css = "form[class='devsite-search-form']")
    private WebElement formSearch;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleCloudSearchResultsPage enterSearchText(SearchInput searchInput) throws InterruptedException {
        inputSearch.click();
        inputSearch.sendKeys(searchInput.getSearchInputText());
        formSearch.submit();
        Thread.sleep(5000);
        return new GoogleCloudSearchResultsPage(driver);
    }



}
