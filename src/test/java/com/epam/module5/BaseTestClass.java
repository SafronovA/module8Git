package com.epam.module5;

import com.epam.module5.pages.MainPage;
import com.epam.module5.pages.SignInPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    WebDriver driver;
    MainPage mainPage;
    SignInPage signInPage;

    private final String TESTED_RESOURCE = "https://github.com";
    private final String LOGIN = "yidutax@hurify1.com";
    private final String PASSWORD = "safronTestGit12345";
    protected final String REPOSITORY_NAME = "Repository_For_Experiments";
    protected final String README_FILE_NAME = "README.md";
    protected final String TEST_FILE_NAME = "testFile.txt";
    protected final String TITLE_AFTER_DELETING = "Your repository \"safronTest/" + REPOSITORY_NAME + "\" was successfully deleted.";
    protected final String BIO = "Safronov";


    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\IdeaProjects\\module5\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 700));
        driver.get(TESTED_RESOURCE);
        mainPage = PageFactory.initElements(driver, MainPage.class);

        signIn(LOGIN, PASSWORD);
    }

    protected void signIn(String login, String password){
        signInPage = mainPage.clickSignIn();
        mainPage = signInPage.authorized(login, password);
    }

    @AfterClass(enabled = false)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
