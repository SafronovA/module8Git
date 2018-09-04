package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CreateNewRepositoryPage {
    WebDriver driver;

    public CreateNewRepositoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(id = "repository_name")
    private WebElement repositoryNameInput;
    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[3]/button")
    private WebElement createRepositoryButton;


    public RepositoryPage createRepository(String repoName) throws InterruptedException {
        repositoryNameInput.sendKeys(repoName);
        TimeUnit.SECONDS.sleep(2);
        createRepositoryButton.click();
        return new RepositoryPage(driver);
    }
}
