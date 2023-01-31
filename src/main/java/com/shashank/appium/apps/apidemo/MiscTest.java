package com.shashank.appium.apps.apidemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscTest extends BaseTest {

    @Test
    public void miscTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc, 'Preference dependencies')]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElements(By.className("android.widget.RelativeLayout")).get(1).click();

        String title = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title, "WiFi settings");

        driver.setClipboardText("Amazing Shashank");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(2000);
    }
}
