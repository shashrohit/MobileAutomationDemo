package com.shashank.appium.apps.apidemo;

import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivityTest extends BaseTest {

    @Test
    public void activityTest() {

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElements(By.className("android.widget.RelativeLayout")).get(1).click();

        String title = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Amazing Shashank");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
