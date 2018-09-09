package com.epam.module5.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteExistingRepository extends BaseTest {

    @Test(dependsOnGroups = "AddNewFileToRepository")
    public void deleteRepositoryTest() {
//        mainPage.signIn();
        String actualTitleAfterDeleting = mainPage.openYourProfile()
                                                  .clickRepositoryLink()
                                                  .chooseRepository(REPOSITORY_NAME)
                                                  .deleteRepository(REPOSITORY_NAME)
                                                  .getTitleAfterDeleting();
        Assert.assertEquals(actualTitleAfterDeleting, TITLE_AFTER_DELETING);
    }

}
