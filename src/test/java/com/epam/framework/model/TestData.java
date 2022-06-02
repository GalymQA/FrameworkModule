package com.epam.framework.model;

public class TestData {

    private String searchInputText;
    private String numberOfInstances;
    private String emailAccount;

    public String getSearchInputText() {
        return searchInputText;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public TestData(String searchInputText, String numberOfInstances, String emailAccount) {
        this.searchInputText = searchInputText;
        this.numberOfInstances = numberOfInstances;
        this.emailAccount = emailAccount;
    }

}
