package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultSearchPage {
    private WebDriver driver;

    public ResultSearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void clickUsersLink(){

    }
}
