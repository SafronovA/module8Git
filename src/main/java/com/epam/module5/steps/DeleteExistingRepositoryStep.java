package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class DeleteExistingRepositoryStep extends BaseStep{
    private HomePage homePage;

    public DeleteExistingRepositoryStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean repositoryIsDeleted(){
        return deleteRepository().getTitleAfterDeleting().equals(TITLE_AFTER_DELETING);
    }

    private HomePage deleteRepository(){
        return homePage.signIn()
                .openYourProfile()
                .clickRepositoryLink()
                .chooseRepository(REPOSITORY_NAME)
                .deleteRepository(REPOSITORY_NAME);
    }
}

