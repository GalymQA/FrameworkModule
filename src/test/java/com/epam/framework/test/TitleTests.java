package com.epam.framework.test;

import org.testng.annotations.Test;
import com.epam.framework.pages.GoogleCloudPage;

// mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml -Denvironment=dev clean test

public class TitleTests extends CommonConditions {

    @Test
    public void verifyTitleOfGoogleCloud() {
        new GoogleCloudPage(driver).openPage();
    }

}
