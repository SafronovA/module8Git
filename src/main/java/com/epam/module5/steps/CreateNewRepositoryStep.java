package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import com.epam.module5.pages.RepositoryPage;
import org.openqa.selenium.WebDriver;

public class CreateNewRepositoryStep extends BaseStep{
    private HomePage homePage;

    public CreateNewRepositoryStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean repositoryIsCreated(){
        return createRepository().getTitleText().equals(REPOSITORY_NAME);
    }

    private RepositoryPage createRepository(){
        return homePage.signIn()
                .openYourProfile()
                .clickRepositoryLink()
                .clickNewLink()
                .createRepository(REPOSITORY_NAME);
    }

}
