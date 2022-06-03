package com.epam.framework.test;

import com.epam.framework.model.PricingInputs;
import com.epam.framework.model.SearchInput;
import com.epam.framework.model.YopMailInput;
import com.epam.framework.pages.GoogleHomePage;
import com.epam.framework.pages.GoogleCalculatorPage;
import com.epam.framework.pages.YopMailHomePage;
import com.epam.framework.pages.YopMailInboxPage;
import com.epam.framework.service.PricingInputsCreator;
import com.epam.framework.service.SearchInputCreator;
import com.epam.framework.service.YopMailInputCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends CommonConditions {

    @Test(description = "Verify delivery of a Google Cloud price quote to Yop Mail")
    public void verifyPriceTest() throws InterruptedException {
        SearchInput searchInput = SearchInputCreator.withSearchInputFromProperty();
        PricingInputs pricingInputs = PricingInputsCreator.withPricingInputsFromProperty();
        YopMailInput yopMailInput = YopMailInputCreator.withYopMailInputFromProperty();
        GoogleCalculatorPage googleCalculatorPage = enterSearchText(searchInput);
        googleCalculatorPage = enterDetailsOfInstances(googleCalculatorPage, pricingInputs);
        String totalCostInCalculator = getTotalCostInCalculator(googleCalculatorPage);
        YopMailInboxPage yopMailInboxPage = createEmailAccountAtYopMail(googleCalculatorPage, yopMailInput);
        String createdEmailName = getCreatedEmailName(yopMailInboxPage);
        yopMailInboxPage = deleteAllEmailsInInbox(yopMailInboxPage);
        googleCalculatorPage = sendPriceToEmail(googleCalculatorPage, createdEmailName);
        String totalCostInEmail = getTotalCostInEmail(googleCalculatorPage);

        Assert.assertEquals(totalCostInCalculator, totalCostInEmail, "Calculator and email costs are different.");
    }

    private GoogleCalculatorPage enterSearchText(SearchInput searchInput) {
        return new GoogleHomePage(driver)
                .openPage()
                .enterSearchText(searchInput)
                .clickPricingCalculatorLink();
    }

    private GoogleCalculatorPage enterDetailsOfInstances(
            GoogleCalculatorPage googleCalculatorPage,
            PricingInputs pricingInputs) {
        return googleCalculatorPage.chooseSectionComputeEngine()
                .enterNumberOfInstances(pricingInputs)
                .enterOperatingSystem(pricingInputs)
                .enterVirtualMachineClass(pricingInputs)
                .enterSeries(pricingInputs)
                .enterInstanceType(pricingInputs)
                .checkAddGPUsCheckbox()
                .enterGPUType(pricingInputs)
                .enterNumberOfGPUs(pricingInputs)
                .enterLocalSSD(pricingInputs)
                .enterDataCenterLocation(pricingInputs)
                .enterCommittedUsage(pricingInputs)
                .requestFormToSendEstimates(pricingInputs);
    }

    private String getTotalCostInCalculator(GoogleCalculatorPage googleCalculatorPage) {
        return googleCalculatorPage.getTotalCostInCalculator();
    }

    private YopMailInboxPage createEmailAccountAtYopMail(
            GoogleCalculatorPage googleCalculatorPage,
            YopMailInput yopMailInput) {
        YopMailHomePage yopMailHomePage = googleCalculatorPage.createYopMailTabAndSwitch();
        return yopMailHomePage
                .openPage()
                .createEmailAccount(yopMailInput);
    }

    private String getCreatedEmailName(YopMailInboxPage yopMailInboxPage) {
        return yopMailInboxPage.getCreatedEmailName();
    }

    private YopMailInboxPage deleteAllEmailsInInbox(YopMailInboxPage yopMailInboxPage) {
        return yopMailInboxPage.deleteAllEmailsInInbox();
    }

    private GoogleCalculatorPage sendPriceToEmail(
            GoogleCalculatorPage googleCalculatorPage,
            String createdEmailName) {
        return googleCalculatorPage.sendPricingToEmail(createdEmailName);
    }

    private String getTotalCostInEmail(GoogleCalculatorPage googleCalculatorPage) throws InterruptedException {
        return googleCalculatorPage.switchToYopMailTab().getTotalCostInEmail();
    }

}
