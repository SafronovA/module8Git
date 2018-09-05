package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateNewRepositoryPage {
    private WebDriver driver;

    public CreateNewRepositoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(id = "repository_name")
    private WebElement repositoryNameInput;
    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[3]/button")
    private WebElement createRepositoryButton;


    public RepositoryPage createRepository(String repoName) throws InterruptedException {
        new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOf(repositoryNameInput));
        repositoryNameInput.sendKeys(repoName);
        new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(createRepositoryButton));
        createRepositoryButton.click();
        return new RepositoryPage(driver);
    }
}
