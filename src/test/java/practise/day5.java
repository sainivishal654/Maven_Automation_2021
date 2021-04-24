package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day5 {
    public static void main(String[] args) throws InterruptedException {

        //set the System property of where the driver is located so you can use it
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //define the WebDriver with a variable to use
        WebDriver driver = new ChromeDriver();

        //navigate/get to google home page

        driver.navigate().to("https://www.youtube.com");

        //maximize the driver
        driver.manage().window().maximize();

        //enter the keyword on google search field
        driver.findElement(By.xpath("//*[@id='search']")).sendKeys("Bhagham Bhag");

        //hit submit on google search button
        driver.findElement(By.xpath("//*[@class='style-scope ytd-searchbox']")).submit();
        driver.findElement(By.xpath("//*[@class='style-scope yt-img-shadow']")).click();
        driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']")).click();





    }
}
