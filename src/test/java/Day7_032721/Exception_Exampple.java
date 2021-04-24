package Day7_032721;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Exception_Exampple {
    public static void main(String[] args) throws InterruptedException, IOException {
        //kill all chrome instances that are opened
//Runtime.getRuntime().exec("Killtask /F /IM chromedriver.exe /T");

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

//navigate to bing home page
        try {
            driver.navigate().to("https://www.bing.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to bing. " + e);
        }//end of navigate exception

        Thread.sleep(2500);

//enter a keyword on search field
        try{
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on Search field. " + e);
        }//end of search exception

//click on search icon
        try{
            driver.findElement(By.xpath("//*[@for='sb_form_go']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on search icon. " + e);
        }//end of search icon exception

    }
}
