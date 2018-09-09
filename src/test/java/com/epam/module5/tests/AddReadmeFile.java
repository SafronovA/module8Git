package com.epam.module5.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReadmeFile extends BaseTest {

    @Test(groups = "AddReadmeFile", dependsOnGroups = "CreateNewRepository")
    public void addReadmeToRepositoryTest() {
//        mainPage.signIn();
        Assert.assertTrue(mainPage.openYourProfile()
                                  .clickRepositoryLink()
                                  .chooseRepository(REPOSITORY_NAME)
                                  .includeReadmeFile()
                                  .checkFileAvailability(README_FILE_NAME));
    }

}
