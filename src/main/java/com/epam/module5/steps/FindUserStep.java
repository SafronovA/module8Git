package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import com.epam.module5.pages.ResultSearchPage;
import org.openqa.selenium.WebDriver;

public class FindUserStep extends BaseStep{
    private HomePage homePage;
    private ResultSearchPage resultSearchPage;

    public FindUserStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public FindUserStep findUser(){
        resultSearchPage = homePage.fillSearchInput(FIND_USER)
                                   .clickUsersLink();
        return this;
    }

    public boolean userIsFind(){
       return resultSearchPage.checkAvailability(FIND_USER);
    }

}
