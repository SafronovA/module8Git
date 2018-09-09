package com.epam.module5.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewFileToRepository extends BaseTest {

    @Test(groups = "AddNewFileToRepository", dependsOnGroups = "AddReadmeFile")
    public void addNewFileToRepositoryTest() {
//        mainPage.signIn();
        Assert.assertTrue(mainPage.openYourProfile()
                                  .clickRepositoryLink().chooseRepository(REPOSITORY_NAME)
                                  .createNewFile(TEST_FILE_NAME)
                                  .checkFileAvailability(TEST_FILE_NAME));
    }

}
