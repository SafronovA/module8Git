package com.epam.module5.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EditBio extends BaseTest {

    @Test(groups = "EditBio", dependsOnGroups = "FindUser")
    public void editBioTest(){
        mainPage.signIn();
        String actualBio = mainPage.openYourProfile()
                                   .addOrEditBio(BIO)
                                   .getBioValue();
        Assert.assertEquals(actualBio, BIO);
    }

}