package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;

public class MouseActions {
    public static void main(String[] args) throws IOException, InterruptedException {
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the chromeoptions arguements
        ChromeOptions options = new ChromeOptions();

        //maximize my driver (doesn't work for mac)
        //options.addArguments("start-maximized");


        //set the driver to incognito mode
        options.addArguments("incognito");

        //set it to headless
        //options.addArguments("headless");

        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //kill all chrome instances that are opened
//for windows
//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//for mac
        //Runtime.getRuntime().exec("killall -KILL chromedriver");
        // Thread.sleep(1000);

        //navigate to usps home page
        try {
            driver.navigate().to("https://www.usps.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to usps. " + e);
        }//end of navigate exception

//define the mouse actions
        Actions actions = new Actions(driver);

//hover to Quick tools tab
        try{
            //store your element as WebElement
            WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
            //move your mouse actions to quick tools fro dropdown to appear
            //you always end your mouse actions with .perform()
            actions.moveToElement(quickTools).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to Quick Tools. " + e);
        }//end of quick tools exception

//click on track a package using mouse actions
        try{
            //store your element as WebElement
            WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
            actions.moveToElement(trackPackage).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to click on track a package. " + e);
        }//end of track a package exception

        Thread.sleep(3000);

//Enter a tracking number using mouse actions
        try{
            //store your element as WebElement
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
            actions.moveToElement(trackingField).click().sendKeys("12345678").perform();
        } catch (Exception e) {
            System.out.println("Unable to enter value on tracking input field. " + e);
        }//end of tracking input exception






    }//end of main method
}//end of java class
