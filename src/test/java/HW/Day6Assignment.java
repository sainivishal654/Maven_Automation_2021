package HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Day6Assignment {
    public static void main(String[] args) throws InterruptedException {

        //array lists
        String[] purchasePrice, downPayment, interestRate, mortgageTerm, PMI;

        purchasePrice = new String[3];
        purchasePrice[0] = "23000";
        purchasePrice[1] = "24000";
        purchasePrice[2] = "25000";

        downPayment = new String[3];
        downPayment[0] = "5";
        downPayment[1] = "8";
        downPayment[2] = "12";

        mortgageTerm = new String[3];
        mortgageTerm[0]= "15";
        mortgageTerm[1]= "25";
        mortgageTerm[2]= "30";


        interestRate = new String[3];
        interestRate[0] = "2";
        interestRate[1] = "3";
        interestRate[2] = "4";

        PMI = new String[3];
        PMI[0] = "0.40";
        PMI[1] = "0.45";
        PMI[2] = "0.50";


        //Month & Year
       String[] StartMonth = new String[3];
       StartMonth[0] = "Jun";
       StartMonth[1] = "Jul";
      StartMonth[2] = "Aug";


        String[] StartYear = new String[3];
        StartYear[0] = "2020";
        StartYear[1] = "2021";
        StartYear[2] = "2022";




        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //loop statement
        for (int i=0; i<purchasePrice.length;i++) {

            //navigate to mortgage calc page

            driver.navigate().to("http://www.mlcalc.com");
            Thread.sleep(200);

            //full window
            driver.manage().window().maximize();

            //verify the title with your expected
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("auto loan calculator")) {
                System.out.println("Title matches");
            } else {
                System.out.println("Your Title didn't match. The correct title is: " + actualTitle + ".");
            }


           //clear and store  new loan amount
           WebElement purchasepriz = driver.findElement(By.xpath("//input[@name='ma']"));
            purchasepriz.clear();
            purchasepriz.sendKeys(purchasePrice[i]);
           Thread.sleep(200);

           //clear and store the new down paymetn
           WebElement downPymnt = driver.findElement(By.xpath("//input[@name='dp']"));
            downPymnt .clear();
            downPymnt .sendKeys(downPayment[i]);
           Thread.sleep(200);

           //clear and store the new MortgageTerm
            WebElement mortgagetrm = driver.findElement(By.xpath("//input[@id='mt']"));
            mortgagetrm.clear();
            mortgagetrm.sendKeys(mortgageTerm[i]);
            Thread.sleep(200);

           //clear and store the new interest rate
           WebElement interest = driver.findElement(By.xpath("//input[@name='ir']"));
           interest.clear();
           interest.sendKeys(interestRate[i]);
           Thread.sleep(200);

           //clear and store the new PMI
            WebElement pmi = driver.findElement(By.xpath("//input[@id='mi']"));
            pmi.clear();
            pmi.sendKeys(PMI[i]);
            Thread.sleep(200);

         //select month from dropdown
          //WebElement strtDate = driver.findElement(By.xpath("(//select[@name='sm'])"));
         //select the locator using Select command
         //Select drpdown = new Select(strtDate);
         //using by visible text command select month
         //drpdown.selectByVisibleText (StartMonth[i]);

            WebElement strtDate = driver.findElement(By.xpath("(//select[@name='sm'])"));
            strtDate.click();
            driver.findElement(By.xpath("//*[contains(text(),'"+StartMonth[i]+"')]")).click();
            Thread.sleep(200);

           //select year from dropdown
           //WebElement strtYear = driver.findElement(By.xpath("(//select[@name='sy'])"));
           //select the locator using Select command
           //Select dropdown = new Select(strtYear);
           //using by visible text command select month
         //  dropdown.selectByVisibleText(StartYear[i]);

            WebElement strtYear = driver.findElement(By.xpath("(//select[@name='sy'])"));
            strtYear.click();
            driver.findElement(By.xpath("//*[contains(text(),'"+StartYear[i]+"')]")).click();
           Thread.sleep(200);

           //click on Calculate button
           driver.findElement(By.xpath("//*[@value ='Calculate']")).click();
           Thread.sleep(200);

           //capture the monthly payment using findElements with first index
           String mntPayment = driver.findElements(By.xpath("//td[@class='big']")).get(0).getText();
           System.out.println("Your payment for " + StartMonth[i] + " " + StartYear[i] + " is: " + mntPayment + ".");

       }//end of conditions
        driver.close();
    }//end of main method
}//end of java class
