package com.epam.module5.tests;

import com.epam.module5.pages.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindUser extends BaseTest {

    @Test(groups = "FindUser")
    public void findUserTest(){
        Assert.assertTrue(mainPage.fillSearchInput(FIND_USER)
                                  .clickUsersLink()
                                  .checkAvailability(FIND_USER));
    }
}
