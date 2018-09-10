package com.epam.module5.pages;

import com.epam.module5.user.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    private WebDriver driver;
    private User user = new User();

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;
    @FindBy(xpath = "//input[@type=\"text\" and @name=\"q\"]")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"user-links\"]/li[3]//img")
    private WebElement avatar;
    @FindBy(linkText = "Your profile")
    private WebElement yourProfileLink;
    @FindBy(xpath = "//*[@id=\"js-flash-container\"]/div/div")
    private WebElement titleAfterDeleting;
    @FindBy(xpath = "//*[@id=\"user-links\"]//img")
    private List<WebElement> avatarForCheckingUserAutorization;

    public MainPage signIn() {
        if (!userIsAutorized()) {
            clickSignIn()
                    .authorized(user.getLogin(), user.getPassword());
        } return this;
    }

    public ResultSearchPage fillSearchInput(String str){
        searchInput.clear();
        searchInput.sendKeys(str);
        searchInput.sendKeys(Keys.ENTER);
        return new ResultSearchPage(driver);
    }

    public MainProfilePage openYourProfile(){
        avatar.click();
        yourProfileLink.click();
        return new MainProfilePage(driver);
    }

    private SignInPage clickSignIn(){
        signInLink.click();
        return new SignInPage(driver);
    }

    public String getTitleAfterDeleting(){
        return titleAfterDeleting.getText();
    }

    public boolean userIsAutorized(){
       return avatarForCheckingUserAutorization.size()==1;
    }

}
