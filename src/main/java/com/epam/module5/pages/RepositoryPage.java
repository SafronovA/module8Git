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

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/div/h1/strong/a")
    private WebElement title;
    @FindBy(id = "submit-file")
    private WebElement commitNewFileButton;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[4]/div[3]/form/button")
    private WebElement createNewFileButton;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div/form[2]/div[1]/span[1]/input")
    private WebElement inputFieldNewFileName;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/a[4]")
    private WebElement settingsLink;
    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/summary")
    private WebElement deleteThisRepositoryButton;
    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
    private WebElement inputFieldForDeleting;
    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/details-dialog/div[3]/form/button")
    private WebElement submitButtonForDeleting;


    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[1]/div[1]/p/a")
    private List<WebElement> weRecommendEveryRepositoryIncludeLine;
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[6]/table/tbody/tr/td[2]/span/a")
    private List<WebElement> availableFiles;


    public String getTitleText() {
        return title.getAttribute("innerHTML");
    }

    public void includeReadmeFile() throws InterruptedException {
        clickReadmeLink();
        commitNewFileButton.click();
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
        }
        return request;
    }

    public MainPage deleteRepository(String repositoryName){
        settingsLink.click();
        deleteThisRepositoryButton.click();
        inputFieldForDeleting.sendKeys(repositoryName);
        submitButtonForDeleting.click();
        return new MainPage(driver);
    }

    private void clickReadmeLink() {
        Iterator<WebElement> iterator = weRecommendEveryRepositoryIncludeLine.iterator();
        while (iterator.hasNext()) {
            WebElement currentElement = iterator.next();
            if ((currentElement.getAttribute("innerHTML").trim()).equals("README")) {
                currentElement.click();
                break;
            }
        }
    }
}
