package com.epam.framework.service;

import com.epam.framework.model.YopMailInput;

public class YopMailInputCreator {

    public static final String TESTDATA_YOP_EMAIL_ACCOUNT = "testdata.yop.email.account";

    public static YopMailInput withYopMailInputFromProperty() {
        return new YopMailInput(TestDataReader.getTestData(TESTDATA_YOP_EMAIL_ACCOUNT));
    }

}
