package BaseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import utilities.DriverHelper;


public class WebEventListener implements WebDriverEventListener {
    String href = "";
    DriverHelper dh = new DriverHelper();
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        try{
            String noThanks_alertMessage = "//*[@id = 'onesignal-popover-cancel-button']",
                    close_button = "//*[starts-with(@class, 'styles_closeButton')]",
                    close = "//*[@class = 'closeBtn']",
                    acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']";
            if (dh.isDisplayed(close_button)){
                dh.waitForElementToBeClickable(close_button);
                dh.click(By.xpath(close_button));
                dh.waitForElementToBeDisappear(close_button);
            }
            if (dh.isDisplayed(noThanks_alertMessage)){
                dh.waitForElementToBeClickable(noThanks_alertMessage);
                dh.click(By.xpath(noThanks_alertMessage));
                dh.waitForElementToBeDisappear(noThanks_alertMessage);
            }
            if (dh.isDisplayed(close)){
                dh.waitForElementToBeClickable(close);
                dh.click(By.xpath(close));
            }
            if (dh.isDisplayed(acceptCookies)){
                dh.waitForElementToBeClickable(acceptCookies);
                dh.click(By.xpath(acceptCookies));
            }
        }catch (Exception e){

        }
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }
    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        try {
            href = element.getAttribute("href");
        }catch (Exception e){

        }
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver webDriver) {
        try{
            if (href.contains("http")) {
                String close = "//*[@class = 'closeBtn']",
                        acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']";
                if (dh.isDisplayed(close)) {
                    dh.waitForElementToBeClickable(close);
                    dh.click(By.xpath(close));
                }
                if (dh.isDisplayed(acceptCookies)) {
                    dh.waitForElementToBeClickable(acceptCookies);
                    dh.click(By.xpath(acceptCookies));
                }
            }
        }catch (Exception e){

        }

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        try {
            String close = "//*[@class = 'closeBtn']",
                    acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']";
            if (dh.isDisplayed(close)){
                dh.waitForElementToBeClickable(close);
                dh.click(By.xpath(close));
            }
            if (dh.isDisplayed(acceptCookies)){
                dh.waitForElementToBeClickable(acceptCookies);
                dh.click(By.xpath(acceptCookies));
            }
        }catch (Exception e){

        }
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}