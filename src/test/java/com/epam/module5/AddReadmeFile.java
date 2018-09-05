package com.epam.module5;

import com.epam.module5.pages.MainProfilePage;
import com.epam.module5.pages.RepositoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReadmeFile extends BaseTestClass {
    MainProfilePage mainProfilePage;
    RepositoryPage repositoryPage;

    @Test(priority = 4)
    public void addReadmeToRepositoryTest() {
        addReadmeToRepository();
        Assert.assertTrue(repositoryPage.checkFileAvailability(README_FILE_NAME));
    }

    private void addReadmeToRepository() {
        signIn(LOGIN, PASSWORD);
        mainProfilePage = mainPage.enterYourProfile();
        mainProfilePage.clickRepositoryLink();
        repositoryPage = mainProfilePage.chooseRepository(REPOSITORY_NAME);
        repositoryPage.includeReadmeFile();
        }
}
