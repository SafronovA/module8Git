package com.epam.module5.steps;

import com.epam.module5.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class FindUserStep extends BaseStep{
    private HomePage homePage;

    public FindUserStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean userIsFind(){
       return homePage.fillSearchInput(FIND_USER)
                .clickUsersLink()
                .checkAvailability(FIND_USER);
    }

}
