package com.epam.framework.test;

import org.testng.annotations.Test;
import com.epam.framework.pages.GoogleHomePage;

public class TitleTests extends CommonConditions {

    @Test
    public void verifyTitleOfGoogleCloud() {
        new GoogleHomePage(driver).openPage();
    }

}
