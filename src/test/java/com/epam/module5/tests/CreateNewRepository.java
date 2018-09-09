package com.epam.module5.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewRepository extends BaseTest {

    @Test(groups = "CreateNewRepository", dependsOnGroups = "EditBio")
    public void createRepositoryTest() {
//        mainPage.signIn();
        String actualTitleAfterCreation = mainPage.openYourProfile()
                                                  .clickRepositoryLink()
                                                  .clickNewLink()
                                                  .createRepository(REPOSITORY_NAME)
                                                  .getTitleText();
        Assert.assertEquals(actualTitleAfterCreation, REPOSITORY_NAME);
    }
}
