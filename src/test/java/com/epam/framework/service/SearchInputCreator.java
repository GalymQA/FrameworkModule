package com.epam.framework.service;

import com.epam.framework.model.TestData;

public class SearchInputCreator {

    public static final String TESTDATA_SEARCH_INPUT_TEXT = "testdata.search.input.text";
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    public static final String TESTDATA_EMAIL_ACCOUNT = "testdata.email.account";

    public static TestData withSearchInputsFromProperty() {
        return new TestData(
                TestDataReader.getTestData(TESTDATA_SEARCH_INPUT_TEXT),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_EMAIL_ACCOUNT));
    }

}
