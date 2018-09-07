package com.epam.module5;

import com.epam.module5.pages.CreateNewRepositoryPage;
import com.epam.module5.pages.MainProfilePage;
import com.epam.module5.pages.RepositoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewRepository extends BaseTestClass {
    MainProfilePage mainProfilePage;
    CreateNewRepositoryPage createNewRepositoryPage;
    RepositoryPage repositoryPage;

    @Test(priority = 3)
    public void createRepositoryTest() {
        repositoryPage = createRepository();
        String actualTitle = repositoryPage.getTitleText();
        Assert.assertEquals(actualTitle, REPOSITORY_NAME);

    }

    private RepositoryPage createRepository() {
        signIn();
        mainProfilePage = mainPage.openYourProfile();
        mainProfilePage.clickRepositoryLink();
        createNewRepositoryPage = mainProfilePage.clickNewLink();
        repositoryPage = createNewRepositoryPage.createRepository(REPOSITORY_NAME);
        return new RepositoryPage(driver);
    }
}
