package com.epam.module5;

import com.epam.module5.pages.MainProfilePage;
import com.epam.module5.pages.RepositoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteExistingRepository extends BaseTestClass {
    MainProfilePage mainProfilePage;
    RepositoryPage repositoryPage;

    @Test
    public void deleteRepositoryTest() {
        deleteRepository();
        String actualTitleAfterDeleting = mainPage.getTitleAfterDeleting();
        Assert.assertEquals(actualTitleAfterDeleting, TITLE_AFTER_DELETING);
    }

    private void deleteRepository() {
        mainProfilePage = mainPage.enterYourProfile();
        mainProfilePage.clickRepositoryLink();
        repositoryPage = mainProfilePage.chooseRepository(REPOSITORY_NAME);
        mainPage = repositoryPage.deleteRepository(REPOSITORY_NAME);
    }
}
