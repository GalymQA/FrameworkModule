package com.epam.framework.pages;

import com.epam.framework.model.SearchInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

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

    public String getTitle() {
        return driver.getTitle();
    }

    public GoogleSearchResultsPage enterSearchText(SearchInput searchInput) {
        inputSearch.click();
        inputSearch.sendKeys(searchInput.getSearchInputText());
        formSearch.submit();
        logger.info("Submitted a form with a search input");
        return new GoogleSearchResultsPage(driver);
    }

}
