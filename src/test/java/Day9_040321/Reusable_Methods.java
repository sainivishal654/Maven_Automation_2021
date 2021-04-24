package Day9_040321;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Reusable_Methods {
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


    public static void dropdownByText(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
    }//end of dropdown by text


    public static void Select_ByValue(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(userValue);
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
    }//end of dropdown by text
    //capture text by index
    public static String captureText_Index(WebDriver driver,String xpath,int index,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;
    }//end of dropdown by text
    //capture text
    public static String captureText(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();

        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;
    }//end of dropdown by text


    //method to click on any webelement by explicit wait
    public static void clickOnElement(WebDriver driver,String xpathLocator, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of click method

    //method to submit on any webelement by explicit wait
    public static void submitOnElement(WebDriver driver,String xpathLocator, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit method

    //method to type on any webelement by explicit wait
    public static void sendKeysMethod(WebDriver driver,String xpathLocator, String userValue,String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch to locate an element and click on it
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter value on element " + elementName + " " + e);
        }//end of exception
    }//end of sendkeysMethod

            //method to hover over an element
        public static void hoveroverElement(WebDriver driver,String xpathLocator, String elementName){
            //define by explicit wait
            WebDriverWait wait = new WebDriverWait(driver,10);
            //use try catch to locate an element and click on it

                try {
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
                    //define the mouse actions
                    Actions actions = new Actions(driver);


                    actions.moveToElement(element).perform();

                } catch (Exception e) {
                    System.out.println("Unable to hover to. " +elementName+ "" + e);
                }//end of  exception
            }//end of hoveroverelement

    //method to hover over and click on element
    public static void Hover_Click(WebDriver driver,String xpathLocator, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            //define the mouse actions
            //you always end your mouse actions with .perform()
            actions.moveToElement(element).click().perform();

        } catch (Exception e) {
            System.out.println("Unable to hover over and click on " +elementName+ " " + e);
        }//end of  exception
    }//end of hoveroverelementandclickmethod

    //mouseaction hover and click by index
    public static void Hover_ClickBYIndex(WebDriver driver,String xpathLocator,int index, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathLocator))).get(index);
            //define the mouse actions
            Actions actions = new Actions(driver);

            //you always end your mouse actions with .perform()
            actions.moveToElement(element).click().perform();

        } catch (Exception e) {
            System.out.println("Unable to hover over and click on " +elementName+ " " + e);
        }//end of  exception
    }//end of hover over element and click method by index



    //mouseaction hover and click and send by index
    public static void Hover_Click_Send_BYIndex(WebDriver driver,String xpathLocator,int index, String userValue, String elementName){
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

        } catch (Exception e) {
            System.out.println("Unable to hover over and click on " +elementName+ " " + e);
        }//end of  exception
    }//end of hover over element and click method by index

    //method to type on any webelement by explicit wait
    public static void Hover_SendKeys(WebDriver driver,String xpathLocator, String userValue,String elementName) {
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

        } catch (Exception e) {
            System.out.println("Unable to enter value on element " + elementName + " " + e);
        }//end of exception
    }//end of sendkeysMethod

    //method to select from page







}//end of java class
