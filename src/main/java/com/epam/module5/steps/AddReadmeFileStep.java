package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import com.epam.module5.pages.HomeProfilePage;
import com.epam.module5.pages.RepositoryPage;
import org.openqa.selenium.WebDriver;

public class AddReadmeFileStep extends BaseStep{
    private HomePage homePage;

    public AddReadmeFileStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean readmeFileIsAdded(){
        return addReadmeFile().checkFileAvailability(README_FILE_NAME);
    }

    private RepositoryPage addReadmeFile(){
        return homePage.signIn()
                .openYourProfile()
                .clickRepositoryLink()
                .chooseRepository(REPOSITORY_NAME)
                .includeReadmeFile();
    }
}
