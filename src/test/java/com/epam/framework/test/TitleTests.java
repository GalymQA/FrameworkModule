package com.epam.framework.test;

import org.testng.annotations.Test;
import com.epam.framework.pages.MainPage;

public class TitleTests extends CommonConditions {

    @Test
    public void verifyTitleOfGoogleCloud() {
        new MainPage(driver).openPage();
    }

//    @Test
//    public void oneCanLoginGithub()
//    {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        String loggedInUserName = new LoginPage(driver)
//                .openPage()
//                .login(testUser)
//                .getLoggedInUserName();
//        assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
//    }

}
