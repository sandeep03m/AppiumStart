package com.pagelibraries.ui.gitHub;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.UIUtility;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

  @FindBy(id = "com.github.mobile:id/et_login")
  private WebElement userNameTextBox;
  @FindBy(id = "com.github.mobile:id/et_password")
  private WebElement passwordTextBox;
  @FindBy(id = "com.github.mobile:id/m_login")
  private WebElement signInbutton;

  public LoginPage(final AppiumDriver driver) {
    super(driver);
    initPage(userNameTextBox);
  }

  public GitHomePage clickLogin() {
    signInbutton.click();
    UIUtility.waitForElementInVisibility(driver, 15, By.name("Logging in..."));
    return new GitHomePage(driver);
  }

  public void enterPassword(final String password) {
    passwordTextBox.sendKeys(password);
  }

  public void enterUserName(final String userName) {
    userNameTextBox.sendKeys(userName);
  }

}
