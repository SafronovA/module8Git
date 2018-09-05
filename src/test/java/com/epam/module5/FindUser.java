package com.epam.module5;

import com.epam.module5.pages.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindUser extends BaseTestClass{
    ResultSearchPage resultSearchPage;

    @Test(priority = 1)
    public void findUserOnGitTest(){
        Assert.assertTrue(findUserOnGit());
    }

    private boolean findUserOnGit(){
        resultSearchPage = mainPage.fillSearchInput(FIND_USER);
        resultSearchPage.clickUsersLink();
        return resultSearchPage.checkAvailability(FIND_USER);
    }
}
