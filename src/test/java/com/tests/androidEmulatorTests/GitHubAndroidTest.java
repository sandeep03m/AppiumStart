package com.tests.androidEmulatorTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.MobileUIBase;
import com.pagelibraries.ui.gitHub.GitHomePage;
import com.pagelibraries.ui.gitHub.LoginPage;

public class GitHubAndroidTest extends MobileUIBase {

  // @Test(priority = 0)
  public void gitHubLoginTest() {
    setup();
    final LoginPage loginPage = new LoginPage(getDriver());
    loginPage.enterUserName("test123");
    loginPage.enterPassword("testpwd");
    final GitHomePage homePage = loginPage.clickLogin();
    Assert.assertTrue(homePage.isLoginSuccessFull(), "Enter valid credentials");
  }

  private void setup() {
    super.setUp();
  }

  @Test(priority = 1)
  public void verifyHomeTest() {
    setup();
    final GitHomePage homePage = new GitHomePage(getDriver());
    Assert.assertTrue(homePage.isLoginSuccessFull(), "Enter valid credentials");
    Assert.assertEquals(homePage.verifyMenuCount(), 4,
        "Menus count is not displayed properly");
    homePage.clickHomeOption();
    homePage.swipeToMenu();

  }
}
