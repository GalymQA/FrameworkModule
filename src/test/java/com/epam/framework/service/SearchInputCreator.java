package com.epam.framework.service;

import com.epam.framework.model.SearchInput;

public class SearchInputCreator {

    public static final String TESTDATA_SEARCH_INPUT_TEXT = "testdata.search.input.text";

    public static SearchInput withSearchInputFromProperty() {
        return new SearchInput(TestDataReader.getTestData(TESTDATA_SEARCH_INPUT_TEXT));
    }

}
