package com.epam.framework.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.framework.pages.GoogleHomePage;

public class GoogleTitleTest extends CommonConditions {

    @Test(description = "Verify the title of Google Cloud Home Page")
    public void verifyTitleOfGoogleCloud() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver).openPage();
        String title = googleHomePage.getTitle();
        boolean statusOfTitle = title.contains("Cloud Computing Services") && title.contains("Google Cloud");

        Assert.assertTrue(statusOfTitle, "Google Cloud title is not correct.");
    }

}
