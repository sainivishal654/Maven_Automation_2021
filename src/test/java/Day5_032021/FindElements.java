package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {

        //set the System property of where the driver is located so you can use it
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //define the WebDriver with a variable to use
        WebDriver driver = new ChromeDriver();

        //navigate/get to google home page

        driver.navigate().to("https://www.google.com");

        //maximize the driver
        driver.manage().window().maximize();

        //sleep statement when you go to a specific url page
        Thread.sleep(2000);

        //using findElements click on store links from the class group
        driver.findElements(By.xpath("//*[@class ='MV3Tnb']")).get(1).click();
    }//end of main method
}//end of java class
