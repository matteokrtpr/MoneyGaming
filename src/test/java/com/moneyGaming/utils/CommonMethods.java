package com.moneyGaming.utils;


import com.moneyGaming.testbase.PageInitializer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class CommonMethods extends PageInitializer {


    /**
     * sendText(WebElement element, String textToSend)
     * this method will clear a text box and send text
     *
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * WebDriverWait getWait()
     * this method will return an object of Explicit wait with time set to 20 sec
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * waitForClickable(WebElement element)
     * this method will wait until given element becomes clickable
     *
     * @param element
     */
    public static void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * click(WebElement element)
     * this method will wait till and then click
     */
    public static void click(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    /**
     * getJSExecutor()
     * this method will return an Object of JavascriptExecutor
     *
     * @return JavascriptExecutor
     */
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * jsClick(WebElement element)
     * this method will click using JavascriptExecutor
     *
     * @param element
     */
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }



    public static void selectDropdownValue(WebElement dd, String visibleText) {

        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();//return List<WebElement>
            for (WebElement option : options) {
                if (option.getText().equals(visibleText)) {
                    select.selectByVisibleText(visibleText);
                    break;
                }
            }
        } catch (UnexpectedTagNameException unexpectedTagNameException) {
            unexpectedTagNameException.printStackTrace();

        }

    }


    public static void selectDropdownValue(WebElement dd, int index) {

        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            int ddSize = options.size();

            if (ddSize > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

}
