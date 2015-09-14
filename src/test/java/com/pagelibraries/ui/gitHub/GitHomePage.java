package com.pagelibraries.ui.gitHub;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.UIUtility;

import com.base.BaseClass;

public class GitHomePage extends BaseClass {

  @FindBy(id = "com.github.mobile:id/user_name")
  private WebElement userNameText;

  @FindBy(xpath = ".//android.widget.RelativeLayout[@index=1]")
  private WebElement homeMenu;

  public GitHomePage(final AppiumDriver driver) {
    super(driver);
    initPage(userNameText);
  }

  public void clickHomeOption() {
    homeMenu.click();

    UIUtility.waitForElementInVisibility(driver, 15, By.name("Logging in..."));
  }

  public boolean isLoginSuccessFull() {
    return UIUtility.isElementVisible(driver, 8, userNameText);
  }

  public void swipeToMenu() {
    final WebElement ele = driver
        .findElementByClassName("android.widget.ImageButton");
    System.out.println("X Loc" + ele.getLocation().getX() + "Y Loc"
        + ele.getLocation().getY());
    System.out.println("Height Loc" + ele.getSize().getHeight() + "Width Loc"
        + ele.getSize().getWidth());
    driver.swipe(ele.getLocation().getX() + 4, ele.getLocation().getY() + 1,
        260, 28, 1000);

  }

  public int verifyMenuCount() {
    final List<WebElement> list = driver
        .findElementsByXPath(".//android.widget.RelativeLayout[@resource-id='com.github.mobile:id/navigation_drawer']//android.widget.RelativeLayout");
    if (list != null) {
      return list.size();
    }
    return 0;
  }
}
