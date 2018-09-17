package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class RepositoryPage {
    private  WebDriver driver;

    public RepositoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//strong/a")
    private WebElement title;
    @FindBy(id = "submit-file")
    private WebElement commitNewFileButton;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//div[3]/div[3]//button")
    private WebElement createNewFileButton;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//span[1]/input")
    private WebElement inputFieldNewFileName;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//a[4]")
    private WebElement settingsLink;
    @FindBy(xpath = "//*[@id=\"options_bucket\"]//li[4]//summary")
    private WebElement deleteThisRepositoryButton;
    @FindBy(xpath = "//*[@id=\"options_bucket\"]//li[4]//p/input")
    private WebElement inputFieldForDeleting;
    @FindBy(xpath = "//*[@id=\"options_bucket\"]//li[4]//form/button")
    private WebElement submitButtonForDeleting;


    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//p/a")
    private List<WebElement> weRecommendEveryRepositoryIncludeLine;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//td[2]//a")
    private List<WebElement> availableFiles;


    public String getTitleText() {
        return title.getAttribute("innerHTML");
    }

    public RepositoryPage includeReadmeFile() {
        clickReadmeLink();
        commitNewFileButton.click();
        return this;
    }

    public RepositoryPage createNewFile(String fileName){
        createNewFileButton.click();
        inputFieldNewFileName.sendKeys(fileName);
        commitNewFileButton.click();
        return new RepositoryPage(driver);
    }

    public boolean checkFileAvailability(String filename) {
        boolean request = false;
        Iterator<WebElement> iterator = availableFiles.iterator();
        while (iterator.hasNext()) {
            WebElement currentElement = iterator.next();
            if ((currentElement.getAttribute("innerHTML").trim()).equals(filename)) {
                request = true;
            }
        } return request;
    }

    public HomePage deleteRepository(String repositoryName){
        settingsLink.click();
        deleteThisRepositoryButton.click();
        inputFieldForDeleting.sendKeys(repositoryName);
        submitButtonForDeleting.click();
        return new HomePage(driver);
    }

    private RepositoryPage clickReadmeLink() {
        Iterator<WebElement> iterator = weRecommendEveryRepositoryIncludeLine.iterator();
        while (iterator.hasNext()) {
            WebElement currentElement = iterator.next();
            if ((currentElement.getAttribute("innerHTML").trim()).equals("README")) {
                currentElement.click();
                break;
            }
        } return this;
    }
}
