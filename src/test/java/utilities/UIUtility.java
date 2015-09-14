package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUtility {

  public static boolean isElementVisible(final WebDriver driver,
      final int timeout, final By by) {
    try {
      new WebDriverWait(driver, timeout).until(ExpectedConditions
          .visibilityOfElementLocated(by));
      return true;
    } catch (final TimeoutException e) {
      return false;
    } catch (final NoSuchElementException e) {
      return false;
    }
  }

  public static boolean isElementVisible(final WebDriver driver,
      final int timeout, final WebElement ele) {
    try {
      new WebDriverWait(driver, timeout).until(ExpectedConditions
          .visibilityOf(ele));
      return true;
    } catch (final TimeoutException e) {
      return false;
    } catch (final NoSuchElementException e) {
      return false;
    }
  }

  public static void waitForElementInVisibility(final WebDriver driver,
      final int timeout, final By by) {
    try {
      new WebDriverWait(driver, timeout).until(ExpectedConditions
          .invisibilityOfElementLocated(by));
    } catch (final TimeoutException e) {
      throw e;
    } catch (final NoSuchElementException e) {
      throw e;
    }
  }

  /**
   * wraps WebDriverWait.until to take a screenshot when it fails
   * 
   * @param driver
   * @param timeout
   * @param by
   */
  public static void waitForElementVisibility(final WebDriver driver,
      final int timeout, final By by) {
    try {
      new WebDriverWait(driver, timeout).until(ExpectedConditions
          .visibilityOfElementLocated(by));
    } catch (final TimeoutException e) {
      // GetScreenshot.takeScreenShot(driver);
      throw e;
    } catch (final NoSuchElementException e) {
      // GetScreenshot.takeScreenShot(driver);
      throw e;
    }
  }

  public static void waitForElementVisibility(final WebDriver driver,
      final int timeout, final WebElement element) {
    new WebDriverWait(driver, timeout).until(ExpectedConditions
        .visibilityOf(element));
  }
}
