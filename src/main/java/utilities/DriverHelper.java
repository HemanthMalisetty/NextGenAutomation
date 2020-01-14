package utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;


public class DriverHelper {
    WebDriver driver = LocalDriverManager.getDriver();
    private WebDriverWait webDriverWait = new WebDriverWait(driver, 30);


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }
    public List<WebElement> findElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }
    public void click(String xpath) {
        findElement(xpath).click();
    }
    public void click(By by, String message) {
        message = "can't click "+ by + " at " + by;
        String finalMessage = message;
        new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean> ()  {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(by).click();
                }catch (WebDriverException e){
                    return false;
                }
                return true;
            }
            @Override
            public String toString() {
                return finalMessage;
            }
        });
    }

    public void click(By by){
        click(by, "Cannot click " + by + " at " + by);
    }


    public String getTitle() {
        return driver.getTitle();
    }
    public int getImageWidth(By by) {
        return driver.findElement(by).getSize().getWidth();
    }
    public int getImageWidth(String xpath) {
        return driver.findElement(By.xpath(xpath)).getSize().getWidth();
    }
    public int getImageHeight(By by) {
        return driver.findElement(by).getSize().getHeight();
    }
    public int getImageHeight(String xpath) {
        return driver.findElement(By.xpath(xpath)).getSize().getHeight();
    }
    public String getAttribute(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }
    public String getAttribute(String xpath, String attribute) {
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }
    public void waitForElementToBeClickable(String xpath) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void waitForElementToBeVisible(String xpath) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    public void waitForElementToBeDisappear(String xpath) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
    }
    public void waitForNoOfElements(By by, int noOfElements) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(by, noOfElements));
    }
    public void waitForNoOfElements(String xpath, int noOfElements) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), noOfElements-1));
    }
    public String getText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public String getText(By by) {
        return driver.findElement(by).getText();
    }
    public void sendKeys(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }
    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
    public boolean isDisplayed(String xpath) {
         if (driver.findElements(By.xpath(xpath)).size() > 0) {
             return driver.findElement(By.xpath(xpath)).isDisplayed();
        } else {
            return false;
        }
    }
    public boolean isClickable(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath)).isEnabled();
        } catch (Exception e) {
            return false;
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void selectByVisibleText(By by, String visibleText) {
        Select select = new Select(driver.findElement(by));
        select.deselectByVisibleText(visibleText);
    }
    public void selectByVisibleText(String xpath, String visibleText) {
        Select select = new  Select(driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(visibleText);
    }

    public List<WebElement> getDropdownValues(By by)
    {
        Select select = new  Select(driver.findElement(by));
        return select.getOptions();
    }
    public List<WebElement> getDropdownValues(String xpath) {
        Select select = new  Select(driver.findElement(By.xpath(xpath)));
        return select.getOptions();
    }
    public void scrollIntoView(String locator) {
        WebElement element = findElement(locator);
        ((JavascriptExecutor) driver).executeAsyncScript("arguments[0].scrollIntoView(true);", element);
    }

    public Set<String> getAvailableWindows() {
        return driver.getWindowHandles();
    }
    public void hoverOnElement(String xpath) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(By.xpath(xpath))).build().perform();
    }
    public String getTextColorRgba(String xpath) {
        String color = driver.findElement(By.xpath(xpath)).getCssValue("color");
        return Color.fromString(color).asRgba();
    }
    public String getTextColorRgb(String xpath) {
        String color = driver.findElement(By.xpath(xpath)).getCssValue("color");
        return Color.fromString(color).asRgb();
    }
    public void waitUntilPageLoads() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
    public void waitForFrameToBeAvailableAndSwitchToIt(By by){
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
    public void switchToFrameByIndex(int index){
        driver.switchTo().frame(index);
    }
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
}
