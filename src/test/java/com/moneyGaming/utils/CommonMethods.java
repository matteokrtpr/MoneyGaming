package com.moneyGaming.utils;

import com.moneyGaming.testbase.BaseClass;
import com.moneyGaming.testbase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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

    public static byte[] takeScreenShot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;

    }


    /**
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * This method will click on a radio button or checkbox by the given list of elements and the value
     *
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value) {

        for (WebElement radioOrCheckBox : radioOrCheckBoxes) {
            String actualValue = radioOrCheckBox.getAttribute("value").trim();
            if (radioOrCheckBox.isEnabled() && actualValue.equals(value)) {
                jsClick(radioOrCheckBox);
                break;
            }
        }
    }

    /**
     * This method will click on a radio button or checkbox by the given list of elements and the text value
     *
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBoxByText(List<WebElement> radioOrCheckBoxes, String value) {

        for (WebElement radioOrCheckBox : radioOrCheckBoxes) {
            String actualValue = radioOrCheckBox.getText().trim();
            if (radioOrCheckBox.isEnabled() && actualValue.equals(value)) {
                jsClick(radioOrCheckBox);
                break;
            }
        }
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


    /**
     * this method will switch to a frame by the given index
     *
     * @param frameIndex
     */
    public static void swithToFrame(int frameIndex) {
        try {
            driver.switchTo().frame(frameIndex);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method will switch to a frame by the given name or ID
     *
     * @param nameOrId
     */
    public static void swithToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method will switch to a frame by the given webElement
     *
     * @param webElement
     */
    public static void switchToFrame(WebElement webElement) {
        try {
            driver.switchTo().frame(webElement);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will switch to a child window
     */
    public static void switchToChildWindow() {

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    static String jsonFile;

    public static String readJson(String FileName) {

        try {
            jsonFile = new String(Files.readAllBytes(Paths.get(FileName)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonFile;
    }



}
