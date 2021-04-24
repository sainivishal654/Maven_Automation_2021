package Day6_032121;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {
    public static void main(String[] args) {
     //set the path to the driver
     System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
     //define the chromeoptions arguements
        ChromeOptions options = new ChromeOptions();

        //maximize my driver (doesn't work for mac)
        options.addArguments("start-maximized");

        //set the driver to incognito mode
        options.addArguments("incognito");

        //set it to headless
        //options.addArguments("headless");

        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo page

        driver.navigate().to("http://www.yahoo.com");

    }// end of main method
}// end of java class
