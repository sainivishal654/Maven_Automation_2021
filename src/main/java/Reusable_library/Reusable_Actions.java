package Reusable_library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Reusable_Actions {
    //create a reusable method for navigate to a page
    public static WebDriver defineTheDriver() throws InterruptedException, IOException {
        //kill all chrome instances that are opened
       // Runtime.getRuntime().exec("taskkill /F /IM chromedriver /T");
        Thread.sleep(1000);
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of navigate method

    public static WebDriver defineTheDriverByHeadless() throws InterruptedException, IOException {
        //kill all chrome instances that are opened
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        options.addArguments("headless");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of navigate method with headless


    public static void dropdownByText(WebDriver driver,String xpath,String userValue,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
            logger.log(LogStatus.PASS,"Successfully selected value " + userValue + " on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of dropdown by textnd of dropdown by text


    public static void selectByValue(WebDriver driver,String xpath,String userValue,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(userValue);
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to select a value from " + elementName + " " + e);

        }//endofexception
    }//end of dropdown by text

    //method to hover over and click on element
    public static void Hover_Click(WebDriver driver,String xpathLocator, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            //define the mouse actions
            //you always end your mouse actions with .perform()
            actions.moveToElement(element).click().perform();
            logger.log(LogStatus.PASS,"Successfully able to click on " + elementName);

        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            System.out.println("Unable to hover over and click on " +elementName+ " " + e);
        }//end of  exception
    }//end of hoveroverelementandclickmethod


    //capture text by index
    public static String captureText_Index(WebDriver driver,String xpath,int index, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to select a value from " + elementName + " " + e);

        }
        return result;
    }//end of dropdown by text
    //capture text


    //method to click on any webelement by explicit wait
    public static void clickOnElement(WebDriver driver,String xpathLocator, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to click on element " + elementName + " " + e);

        }
    }//end of click method

    //method to click on any webelement by index by explicit wait
    public static void clickOnElementByindex(WebDriver driver,WebElement xpathLocator,int index, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.visibilityOf(xpathLocator)).click();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to click on element " + elementName + " " + e);

        }//end of exception
    }//end of click method

    //method to submit on any webelement by explicit wait
    public static void submitOnElement(WebDriver driver,String xpathLocator, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
            logger.log(LogStatus.PASS,"Successfully submit on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to submit on element " + elementName + " " + e);

        }
    }//end of submit method

    //method to type on any webelement by explicit wait
    public static void sendKeysMethod(WebDriver driver,String xpathLocator, String userValue,ExtentTest logger,String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully entered a value on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to enter value on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to enter value on element " + elementName + " " + e);

        }
    }//end of sendkeys method

            //method to hover over an element
        public static void mouseHover(WebDriver driver, String xpathLocator, ExtentTest logger, String elementName){
            //define by explicit wait
            WebDriverWait wait = new WebDriverWait(driver,10);
            //mouse action command
            Actions actions = new Actions(driver);
            //use try catch to locate an element and click on it
            try{
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
                actions.moveToElement(element).perform();
                logger.log(LogStatus.PASS,"Successfully hover to " + elementName);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to hover to an element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to hover to an element " + elementName + " " + e);
                getScreenShot(driver,elementName,logger);
            }
        }//end of mouseHover/end of hoveroverelement

    //method to click on any webelement by explicit wait
    public static void click_Element(WebDriver driver,String xpathLocator, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to click on element " + elementName + " " + e);

        }
    }//end of click method
//end of hoveroverelementandclickmethod

    //method to click on any webelement by explicit wait
public static void closePopupIfExist(WebDriver driver,String xpathLocator, ExtentTest logger, String elementName){
    //define by explicit wait
    WebDriverWait wait = new WebDriverWait(driver,10);
    //use try catch to locate an element and click on it
    try{
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        logger.log(LogStatus.PASS,"Successfully able to close " + elementName);
    } catch (Exception e) {
        logger.log(LogStatus.FAIL,"Unable to close " + elementName + " " + e);
        getScreenShot(driver,elementName,logger);
        System.out.println("Popup " + elementName + " is not present. Move on to the next step");
    }
}//end of closePopupIfExist

    //mouseaction hover and click by index
    public static void Hover_ClickBYIndex(WebDriver driver,String xpathLocator,int index, ExtentTest logger, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathLocator))).get(index);
            //define the mouse actions
            Actions actions = new Actions(driver);

            //you always end your mouse actions with .perform()
            actions.moveToElement(element).click().perform();

            logger.log(LogStatus.PASS,"Successfully able to click on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to hover over and click on " +elementName+ " " + e);
        }//end of  exception
    }//end of hover over element and click method by index



    //mouseaction hover and click and send by index
    public static void Hover_Click_Send_BYIndex(WebDriver driver,String xpathLocator,int index, String userValue, ExtentTest logger,  String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathLocator))).get(index);
            //define the mouse actions
            Actions actions = new Actions(driver);

            //you always end your mouse actions with .perform()
            actions.moveToElement(element).click().perform();
            actions.sendKeys(userValue).perform();

            logger.log(LogStatus.PASS,"Successfully to enter an " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to enter an " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to hover over and click on " +elementName+ " " + e);
        }//end of  exception
    }//end of hover over element and click method by index

    //method to type on any webelement by explicit wait
    public static void Hover_SendKeys(WebDriver driver,String xpathLocator, String userValue,ExtentTest logger, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch to locate an element and click on it
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            actions.moveToElement(element).click();
            element.clear();
            element.sendKeys(userValue);
            //you always end your mouse actions with .perform()

            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to enter value on element " + elementName + " " + e);
        }//end of exception
    }//end of sendkeysMethod

    public static String captureTextbyIndex(WebDriver driver,String xpath,int index,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;
    }//end of capture element by text

    //capture text
    public static String CaptureText(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementName);

        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to select a value from " + elementName + " " + e);
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;
    }//end of dropdown by text


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    //method to select from page







}//end of java class
