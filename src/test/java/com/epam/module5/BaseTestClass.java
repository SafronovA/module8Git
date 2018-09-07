package com.epam.module5;

import com.epam.module5.pages.MainPage;
import com.epam.module5.pages.SignInPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    private enum Driver{
        Firefox, Chrome, IE
    }
    private static Driver driverType;
    protected static WebDriver driver = null;
    MainPage mainPage;
    SignInPage signInPage;

    private static final String REMOTE_URL = "http://localhost:4444/wd/hub";
    private final String TESTED_RESOURCE = "https://github.com";
    protected final String LOGIN = "yidutax@hurify1.com";
    protected final String PASSWORD = "safronTestGit12345";
    protected final String REPOSITORY_NAME = "Repository_For_Experiments";
    protected final String README_FILE_NAME = "README.md";
    protected final String TEST_FILE_NAME = "testFile.txt";
    protected final String TITLE_AFTER_DELETING = "Your repository \"safronTest/" + REPOSITORY_NAME + "\" was successfully deleted.";
    protected final String BIO = "Safronov";
    protected final String FIND_USER = "SafronovA";
    private volatile boolean userIsAutorized = false;

//    @BeforeClass(alwaysRun = true)
//    protected void setUp() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\chromedriver.exe");
////        driver = new ChromeDriver();
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setPlatform(Platform.WINDOWS);
//        driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1650, 700));
////        driver.manage().window().fullscreen();
//        driver.get(TESTED_RESOURCE);
//        mainPage = PageFactory.initElements(driver, MainPage.class);
//    }

    @BeforeClass(alwaysRun = true)
    protected void setUp() throws MalformedURLException {
        startBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 700));

        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    public void startBrowser(){
       driver = getDriver();
       driver.get(TESTED_RESOURCE);
    }

    private static WebDriver getDriver(){
        if (driver == null){
            setDriver();
        }
        return driver;
    }

    private static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
//    public void setDriver(Driver driverType){BaseTestClass.driverType = driverType;}
//
//    public WebDriver getDriver() throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        if(driver == null){
//            switch (driverType){
//                case Chrome:
//                    caps.setBrowserName("chrome");
//                    break;
//                case Firefox:
//                    caps.setBrowserName("firefox");
//                    break;
//                case IE:
//                    caps.setBrowserName("chrome");
//                    break;
//                default:
//                    caps.setBrowserName("chrome");
//                    break;
//            }
//            caps.setPlatform(Platform.WINDOWS);
//            driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().window().setSize(new Dimension(1650, 700));
//        }
//        return driver;
//    }

    protected void signIn(){
        if (!userIsAutorized) {
            signInPage = mainPage.clickSignIn();
            mainPage = signInPage.authorized(LOGIN, PASSWORD);
            userIsAutorized = true;
        }
    }

    @AfterClass
    protected void backOnMainPage(){
        driver.navigate().to(TESTED_RESOURCE);
    }

    @AfterTest
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
