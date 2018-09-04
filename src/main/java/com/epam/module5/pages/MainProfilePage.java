package com.epam.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class MainProfilePage {
    WebDriver driver;

    public MainProfilePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[1]/div[4]/div/div")
    private WebElement bioValue;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[1]/div[4]/button")
    private WebElement addOrEditBioButton;
    @FindBy(xpath = "//div[@class=\"js-length-limited-input-container\"]/textarea")
    private WebElement addOrEditBioInput;
    @FindBy(xpath = "//div[@class=\"js-length-limited-input-container\"]/div/div/button[@type=\"submit\"]")
    private WebElement addOrEditBioSaveButton;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/div[3]/nav/a[2]")
    private WebElement repositoryLink;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/div[4]/div[1]/form/div[2]/a")
    private WebElement newLink;
    @FindBy(xpath = "//*[@id=\"user-repositories-list\"]/ul/li/div/h3/a")
    private List<WebElement> repositoriesList;

    public void addOrEditBio(String text){
        addOrEditBioButton.click();
        addOrEditBioInput.click();
        addOrEditBioInput.clear();
        addOrEditBioInput.sendKeys(text);
        addOrEditBioSaveButton.click();
    }

    public void clickRepositoryLink(){
        repositoryLink.click();
    }

    public CreateNewRepositoryPage clickNewLink(){
        newLink.click();
        return new CreateNewRepositoryPage(driver);
    }

    public RepositoryPage chooseRepository(String repoName){
        Iterator<WebElement> iterator = repositoriesList.iterator();
        while (iterator.hasNext()){
            WebElement currentElement = iterator.next();
            if ((currentElement.getAttribute("innerHTML").trim()).equals(repoName)){
                currentElement.click();
                break;
            }
        }
        return new RepositoryPage(driver);
    }

    public String getBioValue(){
        return bioValue.getAttribute("innerHTML");
    }
}
