package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import com.epam.module5.pages.RepositoryPage;
import org.openqa.selenium.WebDriver;

public class AddNewFileToRepositoryStep extends  BaseStep{
    private HomePage homePage;

    public AddNewFileToRepositoryStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean newFileIsAdded(){
        return addNewFileToRepository().checkFileAvailability(TEST_FILE_NAME);
    }

    private RepositoryPage addNewFileToRepository(){
        return homePage.signIn()
                .openYourProfile()
                .clickRepositoryLink()
                .chooseRepository(REPOSITORY_NAME)
                .createNewFile(TEST_FILE_NAME);
    }
}
