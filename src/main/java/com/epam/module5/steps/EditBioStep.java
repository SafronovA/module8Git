package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import com.epam.module5.pages.HomeProfilePage;
import org.openqa.selenium.WebDriver;

public class EditBioStep extends BaseStep {
    private HomePage homePage;

    public EditBioStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean bioIsEdited(){
        return editBio().getBioValue().equals(BIO);
    }

    private HomeProfilePage editBio(){
       return homePage.signIn()
                .openYourProfile()
                .addOrEditBio(BIO);
    }

}
