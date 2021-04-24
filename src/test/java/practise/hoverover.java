package practise;

import Day9_040321.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class hoverover {

    public static void main(String[] args) throws IOException, InterruptedException {
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the chromeoptions arguements
        ChromeOptions options = new ChromeOptions();

        //maximize my driver (doesn't work for mac)
        //options.addArguments("start-maximized");


        //set the driver to incognito mode
        options.addArguments("incognito");

        options.addArguments("--disable-popup-blocking");

        //set it to headless
        //options.addArguments("headless");

        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //maximize the driver
        driver.manage().window().maximize();


        //kill all chrome instances that are opened
//for windows
//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//for mac
        //Runtime.getRuntime().exec("killall -KILL chromedriver");
         Thread.sleep(1000);


         String qn = "M";




        //navigate to express
        driver.navigate().to("https://www.express.com");
        Thread.sleep(1000);
        //close the popup
        Reusable_Methods.Hover_Click(driver,"//*[@class='_3tHVp']","closepop");
        //hover over men's section
        Reusable_Methods.hoveroverElement(driver,"//a[text()='Men']", "Men's Section");
        Thread.sleep(2000);
        //hover and click on sweaters
        Reusable_Methods.Hover_Click(driver,"//a[text()='Sweatshirts & Hoodies']","Sweatshirt and Hoodies");
        Thread.sleep(2000);

        Reusable_Methods.Hover_Click(driver,"//a[text()='Sweaters']","Sweaters");
        //click on First sweater
        Reusable_Methods.Hover_ClickBYIndex(driver,"//*[@class='_3TJgM']",0,"First Sweatshirt");
        //Select size
        Reusable_Methods.Hover_Click(driver,"//*[text()='"+qn+"']","Size");
        //Reusable_Methods.dropdownByText(driver,"//div[@aria-label='Size selection button group']","XS","size");
        //Reusable_Methods.Hover_ClickBYIndex(driver,"//div[@class='_2ZSXl']",0,"Size");
        // Reusable_Methods.dropdownByText(driver,"//div[@class='_2WVKQ']","XS","size");
        //add to bag

        Reusable_Methods.Hover_Click(driver,"//*[text()='Add to Bag']","Add to Bag");
        //view bag
        Thread.sleep(1500);
        Reusable_Methods.Hover_Click(driver,"//a[text()='View Bag']","View Bag");
        //change quantity
        Reusable_Methods.dropdownByText(driver,"//*[@id='qdd-0-quantity']","2","Quantity");
        //Checkout
        Reusable_Methods.Hover_Click(driver,"//button[@class='btn _9yfmt _194FD _2tFXQ _1s_-v']","Checkout");
        //checkout as Guest
        Reusable_Methods.Hover_Click(driver,"//*[text()='Checkout as Guest']","Checkout as Guest");
        //enter First Name
        Reusable_Methods.sendKeysMethod(driver,"//input[@name='firstname']","Vishal","First Name" );
        //enter Last Name
        Reusable_Methods.sendKeysMethod(driver,"//*[@name='lastname']","Saini","Last Name" );
        //enter email address
        Reusable_Methods.Hover_Click_Send_BYIndex(driver,"//input[@name='email']",0,"vs654@gmail.com","Email Address" );
        //confirm email addres
        Reusable_Methods.Hover_Click_Send_BYIndex(driver,"//input[@aria-label='Confirm Email Address']",0,"vs654@gmail.com","Email Address" );
        //enter phone number
        Reusable_Methods.Hover_Click_Send_BYIndex(driver, "(//input[@name='phone'])",0, "8567654576","Phone");
        //click on continue
        Reusable_Methods.Hover_Click(driver, "//button[contains(@class,'btn _9yfmt')]", "Continue");
        //Select country
        Reusable_Methods.dropdownByText(driver,"//select[@name='shipping.countryCode']","United States","Country");
        Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.line1']","5653 Magnlia ave","Street address");
        Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.line2']","64","Apartment Number");
        Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.postalCode']","08109","postal Code");
        Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.city']","Pennsauken","Shipping City");
        Reusable_Methods.dropdownByText(driver,"//select[@name='shipping.state']","NJ","State");
        Reusable_Methods.Hover_Click(driver, "//button[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", "Continue");
        Thread.sleep(2500);
        Reusable_Methods.Hover_Click(driver, "//span[text()='Continue']", "Confirm shipping method");
        Reusable_Methods.sendKeysMethod(driver,"//input[@id='creditCardNumberInput']","4737564754782345","Credit Card Number");
        Reusable_Methods.dropdownByText(driver,"//select[@name='expMonth']","04","Exp Month");
        Reusable_Methods.dropdownByText(driver,"//select[@name='expYear']","22","Exp Year");
        Reusable_Methods.sendKeysMethod(driver,"//input[@name='cvv']","213","CVV Number");
        Thread.sleep(2500);
        Reusable_Methods.Hover_Click(driver, "//*[text()='Place Order']", "Place Order");

        driver.manage().deleteAllCookies();
//

        //driver.quit();

//

    }//end of main method
}//end of java class
