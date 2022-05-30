package com.epam.framework.test;

import com.epam.framework.model.SearchInput;
import com.epam.framework.pages.GoogleCloudPage;
import com.epam.framework.service.SearchInputCreator;
import org.testng.annotations.Test;

public class TaskTest extends CommonConditions {

    @Test
    public void verifyPriceTest() throws InterruptedException {
        SearchInput testSearchInput = SearchInputCreator.withSearchInputsFromProperty();
        new GoogleCloudPage(driver)
                .openPage()
                .searchText(testSearchInput);
    }

}
