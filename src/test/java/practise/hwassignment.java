package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class hwassignment {
    public static void main(String[] args) throws InterruptedException {

//set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to mlcalc page

        driver.navigate().to("http://www.mlcalc.com");


        WebElement date = driver.findElement(By.id("fpdd"));


        //select april on month dropdown
        WebElement startDate = driver.findElements(By.xpath("(//select[@name='sm'])")).get(2);
        //select the locator using Select command
        Select startdate_1 = new Select(startDate);
        //using by visible text command select month April
        //startdate_1.selectByVisibleText ("May");
        Thread.sleep(3000);
        startdate_1.selectByValue("10");

        //select year on month dropdown
        WebElement startYear = driver.findElements(By.xpath("(//select[@name='sy'])")).get(2);
        //select the locator using Select command
        Select dropdown = new Select(startYear);
        //using by visible text command select month April
        dropdown.selectByVisibleText("2022");



    }
}
