package com.shashank.appium.apps.apidemo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumTest extends BaseTest {

    @Test
    public void appiumTest() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc, 'Preference dependencies')]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElements(By.className("android.widget.RelativeLayout")).get(1).click();

        String title = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Amazing Shashank");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
