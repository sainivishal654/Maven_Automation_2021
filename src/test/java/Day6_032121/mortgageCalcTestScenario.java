package Day6_032121;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mortgageCalcTestScenario {
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

        //navigate to mortgage calc page

        driver.navigate().to("http://www.mortgagecalculator.org");
        Thread.sleep(2000);

        //verify the title with your expected
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Mortgage Calculator")){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. " + actualTitle);
        }//end of conditions

        //store home value first
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the previous data
        homeValue.clear();
        //enter the new home value
        homeValue.sendKeys("350000");

        //store down payment first
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        //clear the previous data
        dPayment.clear();
        //enter the new down value
        dPayment.sendKeys("220000");


        //select april on month dropdown
        WebElement startmonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //select the locator using Select command
        Select dropdown = new Select(startmonth);
        //using by visible text command select month April
        dropdown.selectByVisibleText("May");

        //select april on month dropdown
        WebElement startyear = driver.findElement(By.xpath("//*[@id='start_year']"));
        //select the locator using Select command
        Select drpdown = new Select(startyear);
        //using by visible text command select month April
        drpdown.selectByVisibleText("2020");
//0r
        //if dropdown is not under select tag then you have to use click command to twice
        //click on dropdown
       //startmonth.click();
        //click on dropdown value by text
       //driver.findElement(By.xpath("//*[@text()='May']")).click();

       //click on Calculate button
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(3000);

        //capture the monthly payment using findElements wiht first index
        String mntPayment = driver.findElements(By.xpath("//div[@class='left-cell']")).get(0).getText();
        System.out.println("My monthly payment is " + mntPayment);


    }//end of main method
}//end of java class
