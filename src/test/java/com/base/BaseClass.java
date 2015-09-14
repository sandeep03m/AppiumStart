package com.base;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.UIUtility;

public abstract class BaseClass {
  protected AppiumDriver driver;

  public BaseClass(final AppiumDriver driver) {
    this.driver = driver;
  }

  public void initPage(final WebElement initialElement,
      final WebElement... initialElements) {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    if (initialElement != null) {
      UIUtility.waitForElementVisibility(driver, 15, initialElement);
      for (final WebElement element : initialElements) {
        UIUtility.waitForElementVisibility(driver, 15, element);
      }
    }
  }

}
