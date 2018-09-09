package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(id = "login_field")
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement submitButton;

    public MainPage authorized(String login, String password) {
        System.out.println("вызов метода авторизации");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginInput.click();
        System.out.println("loginInput.click();");
        loginInput.sendKeys(login);
        passwordInput.click();
        passwordInput.sendKeys(password);
        submitButton.submit();
        return new MainPage(driver);
    }

}
