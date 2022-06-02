package com.epam.framework.test;

import com.epam.framework.model.TestData;
import com.epam.framework.pages.GoogleHomePage;
import com.epam.framework.pages.GoogleCalculatorPage;
import com.epam.framework.pages.YopMailHomePage;
import com.epam.framework.pages.YopMailInboxPage;
import com.epam.framework.service.SearchInputCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends CommonConditions {

    @Test(description = "Verify delivery of a Google Cloud price quote to Yop Mail")
    public void verifyPriceTest() throws InterruptedException {
        TestData testData = SearchInputCreator.withSearchInputsFromProperty();
        GoogleCalculatorPage googleCalculatorPage = enterSearchText(testData);
        googleCalculatorPage = enterDetailsOfInstances(googleCalculatorPage, testData);
        String totalCostInCalculator = getTotalCostInCalculator(googleCalculatorPage);
        YopMailInboxPage yopMailInboxPage = createEmailAccountAtYopMail(googleCalculatorPage, testData);
        String createdEmailName = getCreatedEmailName(yopMailInboxPage);
        yopMailInboxPage = deleteAllEmailsInInbox(yopMailInboxPage);
        googleCalculatorPage = sendPriceToEmail(googleCalculatorPage, createdEmailName);
        String totalCostInEmail = getTotalCostInEmail(googleCalculatorPage);
        Assert.assertEquals(totalCostInCalculator, totalCostInEmail, "Calculator and email costs are different.");
    }

    private GoogleCalculatorPage enterSearchText(TestData testData) {
        return new GoogleHomePage(driver)
                .openPage()
                .enterSearchText(testData)
                .clickPricingCalculatorLink();
    }

    private GoogleCalculatorPage enterDetailsOfInstances(
            GoogleCalculatorPage googleCalculatorPage,
            TestData testData) {
        return googleCalculatorPage.chooseSectionComputeEngine()
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
    }

    private String getTotalCostInCalculator(GoogleCalculatorPage googleCalculatorPage) {
        return googleCalculatorPage.getTotalCostInCalculator();
    }

    private YopMailInboxPage createEmailAccountAtYopMail(
            GoogleCalculatorPage googleCalculatorPage,
            TestData testData) {
        YopMailHomePage yopMailHomePage = googleCalculatorPage.createYopMailTabAndSwitch();
        return yopMailHomePage
                .openPage()
                .createEmailAccount(testData);
    }

    private String getCreatedEmailName(YopMailInboxPage yopMailInboxPage) {
        return yopMailInboxPage.getCreatedEmailName();
    }

    private YopMailInboxPage deleteAllEmailsInInbox(YopMailInboxPage yopMailInboxPage) throws InterruptedException {
        return yopMailInboxPage.deleteAllEmailsInInbox();
    }

    private GoogleCalculatorPage sendPriceToEmail(
            GoogleCalculatorPage googleCalculatorPage,
            String createdEmailName) throws InterruptedException {
        return googleCalculatorPage.sendPricingToEmail(createdEmailName);
    }

    private String getTotalCostInEmail(GoogleCalculatorPage googleCalculatorPage) throws InterruptedException {
        return googleCalculatorPage.switchToYopMailTab().getTotalCostInEmail();
    }

}
