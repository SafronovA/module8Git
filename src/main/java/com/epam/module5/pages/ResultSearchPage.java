package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class ResultSearchPage {
    private WebDriver driver;

    public ResultSearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/nav[1]/a[8]")
    private WebElement usersLink;
    @FindBy(xpath = "//*[@id=\"user_search_results\"]/div/div/div[1]/div/a/em")
    private List<WebElement> usersList;

    public void clickUsersLink(){
        usersLink.click();
    }

    public boolean checkAvailability(String checkingOne){
        boolean request = false;
        Iterator<WebElement> iterator = usersList.iterator();
        while (iterator.hasNext()) {
            WebElement currentElement = iterator.next();
            if ((currentElement.getAttribute("innerHTML").trim()).equals(checkingOne)) {
                request = true;
            }
        }
        return request;
    }
}
