package com.epam.framework.test;

import com.epam.framework.pages.YopMailHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YopMailTitleTest extends CommonConditions {

    @Test(description = "Verify the title of Yop Mail Home Page")
    public void verifyTitleOfYopMail() {
        YopMailHomePage yopMailHomePage = new YopMailHomePage(driver).openPage();
        String title = yopMailHomePage.getTitle();
        boolean statusOfTitle = title.contains("YOPmail") && title.contains("Disposable Email Address");

        Assert.assertTrue(statusOfTitle, "Yop Mail title is not correct.");
    }

}
