package com.epam.framework.test;

import com.epam.framework.model.ServerType;
import com.epam.framework.model.SearchInput;
import com.epam.framework.model.YopMailAccount;
import com.epam.framework.pages.GoogleHomePage;
import com.epam.framework.pages.GoogleCalculatorPage;
import com.epam.framework.pages.YopMailHomePage;
import com.epam.framework.pages.YopMailInboxPage;
import com.epam.framework.service.PricingInputsCreator;
import com.epam.framework.service.SearchInputCreator;
import com.epam.framework.service.YopMailInputCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryOfPriceToEmailTest extends CommonConditions {

    @Test(description = "Verify delivery of a Google Cloud price quote to Yop Mail")
    public void verifyPriceTest() throws InterruptedException {
        SearchInput searchInput = SearchInputCreator.withSearchInputFromProperty();
        ServerType serverType = PricingInputsCreator.withPricingInputsFromProperty();
        YopMailAccount yopMailAccount = YopMailInputCreator.withYopMailInputFromProperty();

        GoogleCalculatorPage googleCalculatorPage = enterSearchText(searchInput);
        googleCalculatorPage = enterDetailsOfInstances(googleCalculatorPage, serverType);
        String totalCostInCalculator = getTotalCostInCalculator(googleCalculatorPage);

        YopMailInboxPage yopMailInboxPage = createEmailAccountAtYopMail(googleCalculatorPage, yopMailAccount);
        String createdEmailName = getCreatedEmailName(yopMailInboxPage);
        deleteAllEmailsInInbox(yopMailInboxPage);

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
            ServerType serverType) {
        return googleCalculatorPage.chooseSectionComputeEngine()
                .enterNumberOfInstances(serverType)
                .enterOperatingSystem(serverType)
                .enterVirtualMachineClass(serverType)
                .enterSeries(serverType)
                .enterInstanceType(serverType)
                .checkAddGPUsCheckbox()
                .enterGPUType(serverType)
                .enterNumberOfGPUs(serverType)
                .enterLocalSSD(serverType)
                .enterDataCenterLocation(serverType)
                .enterCommittedUsage(serverType)
                .requestFormToSendEstimates();
    }

    private String getTotalCostInCalculator(GoogleCalculatorPage googleCalculatorPage) {
        return googleCalculatorPage.getTotalCostInCalculator();
    }

    private YopMailInboxPage createEmailAccountAtYopMail(
            GoogleCalculatorPage googleCalculatorPage,
            YopMailAccount yopMailAccount) {
        YopMailHomePage yopMailHomePage = googleCalculatorPage.createYopMailTabAndSwitch();
        return yopMailHomePage
                .openPage()
                .createEmailAccount(yopMailAccount);
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
