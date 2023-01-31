package com.shashank.appium.apps.apidemo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriverLocalService service;
    AndroidDriver driver;

    @BeforeClass
    public void configureAppiumServer() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\DS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
//        service.start();
//
//        File appDir = new File(System.getProperty("user.dir"));
//        File app = new File(appDir, "..\\apk\\Flipkart.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL Android 13.0 Shashank");
        options.setApp("C:\\Users\\DS\\Desktop\\Projects\\MobileAutomationDemo\\src\\main\\java\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void logPress(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
        ));
    }

    public void swipe(WebElement element, String direction){

        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement)element).getId(), "direction", direction,
                "percent", 0.75));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
//        service.stop();
    }
}
