package com.epam.framework.service;

import com.epam.framework.model.SearchInput;

public class SearchInputCreator {

    public static final String TESTDATA_SEARCH_INPUT_TEXT = "testdata.search.input.text";


    public static SearchInput withSearchInputsFromProperty(){
        return new SearchInput(TestDataReader.getTestData(TESTDATA_SEARCH_INPUT_TEXT));
    }

//    public static User withEmptyUsername(){
//        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
//    }
//
//    public static User withEmptyPassword(){
//        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
//    }

}
