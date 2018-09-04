package com.epam.module5;

import com.epam.module5.pages.MainProfilePage;
import com.epam.module5.pages.RepositoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewFileToRepository extends BaseTestClass {
    MainProfilePage mainProfilePage;
    RepositoryPage repositoryPage;

    @Test
    public void addNewFileToRepositoryTest() {
        addNewFileToRepository();
        Assert.assertTrue(repositoryPage.checkFileAvailability(TEST_FILE_NAME));
    }

    private void addNewFileToRepository() {
        mainProfilePage = mainPage.enterYourProfile();
        mainProfilePage.clickRepositoryLink();
        repositoryPage = mainProfilePage.chooseRepository(REPOSITORY_NAME);
        repositoryPage.createNewFile(TEST_FILE_NAME);
    }


}
