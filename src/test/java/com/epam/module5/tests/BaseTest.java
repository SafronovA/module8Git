package com.epam.module5.tests;

import com.epam.module5.DriverManager;
import com.epam.module5.pages.MainPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected MainPage mainPage;

    private final String TESTED_RESOURCE = "https://github.com";
    protected final String REPOSITORY_NAME = "Repository_For_Experiments";
    protected final String README_FILE_NAME = "README.md";
    protected final String TEST_FILE_NAME = "testFile.txt";
    protected final String TITLE_AFTER_DELETING = "Your repository \"safronTest/" + REPOSITORY_NAME + "\" was successfully deleted.";
    protected final String BIO = "Safronov";
    protected final String FIND_USER = "SafronovA";

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        startBrowser();
        driver.get(TESTED_RESOURCE);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterClass(enabled = true)
    protected void backOnMainPage() {
        driver.navigate().to(TESTED_RESOURCE);
    }

    @AfterTest(enabled = true)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void startBrowser() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 700));
    }

//    private enum Driver{
//        Firefox, Chrome, IE
//    }
//    private static Driver driverType;

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

}