package com.epam.module5;

import com.epam.module5.pages.MainProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditBio extends BaseTestClass {
    MainProfilePage mainProfilePage;

    @Test (priority = 2)
    public void editBioTest(){
        editBio();
        String actualBio = mainProfilePage.getBioValue();
        Assert.assertEquals(actualBio, BIO);
    }

    private void editBio() {
        signIn();
        mainProfilePage = mainPage.openYourProfile();
        mainProfilePage.addOrEditBio(BIO);
    }

}