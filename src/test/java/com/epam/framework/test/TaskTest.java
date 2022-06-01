package com.epam.framework.test;

import com.epam.framework.model.SearchInput;
import com.epam.framework.pages.GoogleCloudHomePage;
import com.epam.framework.pages.GoogleCloudPricingCalculatorPage;
import com.epam.framework.pages.YopMailHomePage;
import com.epam.framework.pages.YopMailInboxPage;
import com.epam.framework.service.SearchInputCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TaskTest extends CommonConditions {

    @Test
    public void verifyPriceTest() throws InterruptedException {
        SearchInput testData = SearchInputCreator.withSearchInputsFromProperty();
        GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .enterSearchText(testData)
                .clickPricingCalculatorLink()
                .chooseSectionComputeEngine()
                .enterNumberOfInstances(testData)
                .enterOperatingSystem(testData)
                .enterVMClass(testData)
                .enterSeries(testData)
                .enterMachineType(testData)
                .checkAddGPUsCheckbox()
                .enterGPUType(testData)
                .enterNumberOfGPUs(testData)
                .enterLocalSSD(testData)
                .enterDataCenterLocation(testData)
                .enterCommittedUsage(testData)
                .requestFormToSendEstimates(testData);
        YopMailHomePage yopMailHomePage = googleCloudPricingCalculatorPage.switchToNewlyCreatedYopMailTab();
        YopMailInboxPage yopMailInboxPage = yopMailHomePage
                .openPage()
                .createEmailAccount(testData);
        String createdEmail = yopMailInboxPage.getCreatedEmail();
        googleCloudPricingCalculatorPage = yopMailInboxPage.switchToGoogleCloudPricingCalculatorTab();
        String totalCostInCalculator = googleCloudPricingCalculatorPage.getTotalCostInCalculator();

        System.out.println("********************************************");
        System.out.println("totalCostInCalculator: " + totalCostInCalculator);
        System.out.println("********************************************");

        String totalCostInEmail =googleCloudPricingCalculatorPage
                .sendPricingToEmail(createdEmail)
                .switchToYopMailTab().getTotalCostInEmail();

        System.out.println("********************************************");
        System.out.println("totalCostInEmail: " + totalCostInEmail);
        System.out.println("********************************************");


        assertThat(totalCostInCalculator, is(equalTo(totalCostInEmail)));

    }

}
