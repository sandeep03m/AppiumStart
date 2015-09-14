package com.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public abstract class MobileUIBase {

  protected AppiumDriver driver;
  private final String   hubUrl = "http://127.0.0.1:4723/wd/hub";

  private File getAppFilePath() {
    final File classpathRoot = new File(System.getProperty("user.dir"));
    final File appDir = new File(classpathRoot, "/apps/app-debug");
    final File app = new File(appDir, "app-debug.apk");
    return app;
  }

  protected AppiumDriver getDriver() {
    return driver;
  }

  public void setUp() {
    // set up appium
    final DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("platformVersion", "5.0.1");
    capabilities.setCapability("app", getAppFilePath().getAbsolutePath());
    // capabilities.setCapability("appPackage","com.example.android.contactmanager");
    // capabilities.setCapability("appActivity", ".ContactManager");
    try {
      driver = new AndroidDriver(new URL(hubUrl), capabilities);
    } catch (final MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      System.out.println("Driver Quitting after method");
      driver.quit();
    }
  }

}
