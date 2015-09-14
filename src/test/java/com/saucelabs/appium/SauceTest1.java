package com.saucelabs.appium;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SauceTest1 {

  public static final String USERNAME   = "sandeepmiriyala";
  public static final String ACCESS_KEY = "1dc3e559-ba25-4e89-a4da-be9f3516eb30";
  public static final String URL        = "http://"
                                            + USERNAME
                                            + ":"
                                            + ACCESS_KEY
                                            + "@ondemand.saucelabs.com:80/wd/hub";

  @Test
  public void test1() throws Exception {

    final DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows XP");
    caps.setCapability("version", "43.0");

    final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

    driver.get("https://login.yahoo.com");
    System.out.println("title of page is: " + driver.getTitle());

    driver.quit();
  }
}
