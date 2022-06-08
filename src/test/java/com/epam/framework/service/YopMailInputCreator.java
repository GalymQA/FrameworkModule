package com.epam.framework.service;

import com.epam.framework.model.YopMailAccount;

public class YopMailInputCreator {

    public static final String TESTDATA_YOP_EMAIL_ACCOUNT = "testdata.yop.email.account";

    public static YopMailAccount withYopMailInputFromProperty() {
        return new YopMailAccount(TestDataReader.getTestData(TESTDATA_YOP_EMAIL_ACCOUNT));
    }

}
