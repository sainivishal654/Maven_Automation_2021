package Day7_032721;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Handling_tabs {
    public static void main(String[] args) throws InterruptedException {
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

//navigate to oxford health home page
        driver.navigate().to("https://www.oxhp.com/");
        Thread.sleep(3000);
//using contains only choose the unique portion of the value
//to click on members link
        driver.findElement(By.xpath("//*[contains(@onmouseover,'/images/home/members_hm_on')]")).click();
        Thread.sleep(3000);
//click on find a physician link
        driver.findElement(By.xpath("//*[contains(text(),'Find a Physician')]")).click();

//using Arraylist we can switch to new tab(1)
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//switch to new tab 2
        driver.switchTo().window(tabs.get(1));
//click on metro to verify you are on that new tab
        Thread.sleep(1000);
        try {
            driver.findElement(By.xpath("//*contains(text(),'Metro']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Metro link. " + e);
        }

         driver.findElement(By.xpath("//*[@title = ‘myButton’]")).click();
//close the new tab
       // driver.close();
//switch back to old tab
        //driver.switchTo().window(tabs.get(0));



    }
}





/** contains is used when the elements is too big or has too much white space so we only use the protion of the unique element
 * handling tabls when you're working with one or more tabs**/
