package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import com.epam.module5.pages.RepositoryPage;
import org.openqa.selenium.WebDriver;

public class CreateNewRepositoryStep extends BaseStep{
    private HomePage homePage;
    private RepositoryPage repositoryPage;

    public CreateNewRepositoryStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public CreateNewRepositoryStep createRepository(){
        repositoryPage = homePage.signIn()
                                 .openYourProfile()
                                 .clickRepositoryLink()
                                 .clickNewLink()
                                 .createRepository(REPOSITORY_NAME);
        return this;
    }

    public boolean repositoryIsCreated(){
        return repositoryPage.getTitleText().equals(REPOSITORY_NAME);
    }

}
