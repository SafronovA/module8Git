package com.epam.module5.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static WebDriver driver;
    private static final String REMOTE_URL = "http://localhost:4444/wd/hub";


    public static WebDriver getDriver(){
        if (driver == null){
            setDriver();
        } return driver;
    }

    private static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\geckodriver.exe");
        DesiredCapabilities capabilitiesChrome = DesiredCapabilities.chrome();
        DesiredCapabilities capabilitiesFirefox = DesiredCapabilities.firefox();
        capabilitiesChrome.setPlatform(Platform.WINDOWS);
        capabilitiesFirefox.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilitiesChrome);
        } catch (MalformedURLException e) {e.printStackTrace();}
    }
}
