package com.epam.module5;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static WebDriver driver = null;
    private static final String REMOTE_URL = "http://localhost:4444/wd/hub";


    public static WebDriver getDriver(){
        if (driver == null){
            setDriver();
        }
        return driver;
    }

    private static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
