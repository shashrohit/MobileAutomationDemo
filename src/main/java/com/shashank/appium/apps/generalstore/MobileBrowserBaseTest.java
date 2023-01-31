package com.shashank.appium.apps.generalstore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileBrowserBaseTest {

    AndroidDriver driver;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL Android 12.0 Shashank");
        options.setChromedriverExecutable("C:\\Users\\DS\\Desktop\\Projects\\MobileAutomationDemo\\src\\main\\java\\resources\\chromedriver.exe");
        options.setCapability("browserName", "Chrome");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
