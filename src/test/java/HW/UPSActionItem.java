package HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class UPSActionItem {
    public static void main(String[] args) throws InterruptedException {

        //Define the variables

        ArrayList<String> zipcode= new ArrayList<>();
        zipcode.add("08109");
        zipcode.add("08002");
        zipcode.add("08007");

        ArrayList<String> locationType= new ArrayList<>();
        locationType.add("Collection Boxes");
        locationType.add("Self-Service Kiosks");
        locationType.add("Contract Postal Unit");

        ArrayList<String> Miles= new ArrayList<>();
        Miles.add("20 Miles");
        Miles.add("10 Miles");
        Miles.add("50 Miles");

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

        //for mac
        //Runtime.getRuntime().exec("killall -KILL chromedriver");
        // Thread.sleep(1000)

        for (int i=0; i<zipcode.size(); i++) {
            //navigate to usps home page
            try {
                driver.navigate().to("https://www.usps.com");
            } catch (Exception e) {
                System.out.println("Unable to navigate to usps. " + e);
            }//end of navigate exception

            //verify the title with your expected
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Welcome | USPS")) {
                System.out.println("Title matches: "+ actualTitle);
            } else {
                System.out.println("Your Title didn't match. The correct title is: " + actualTitle + ".");
            }

// the mouse actions
            Actions actions = new Actions(driver);

//hover to send tab
            try {
                //store your element as WebElement
                WebElement send = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
                //move your mouse actions to send  from dropdown to appear
                //you always end your mouse actions with .perform()
                actions.moveToElement(send).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to send. " + e);
            }//end of send exception

            //store usps location as WebElement
            try {
                WebElement uspslocation = driver.findElement(By.xpath("//a[text()='Find USPS Locations']"));
                actions.moveToElement(uspslocation).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on Find USPS Location. " + e);
            }//end of Find a USPS Location exception

            Thread.sleep(2000);
            try {
                //store your element as WebElement
                WebElement LField = driver.findElement(By.xpath("//input[@id = 'city-state-input']"));
                actions.moveToElement(LField).click().sendKeys(zipcode.get(i)).perform();
            } catch (Exception e) {
                System.out.println("Unable to enter value on Find a location. " + e);
            }//end of zipcode input exception

            try {
                //store your element as WebElement
                WebElement LType = driver.findElement(By.xpath("//*[@id = 'post-offices-select']"));
                actions.moveToElement(LType).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to location Types. " + e);
            }//end of  location Types exception

            try {
                //store your element as WebElement
                WebElement SelectLType = driver.findElement(By.xpath("//a[(text()='" + locationType.get(i) + "')]"));
                actions.moveToElement(SelectLType).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to select a location. " + e);
            }//end of selecting location Types exception

            try {
                //store your element as WebElement
                WebElement range = driver.findElement(By.xpath("//*[@id='within-select']"));
                actions.moveToElement(range).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to within field. " + e);
            }//end of  within field exception

            try {
                //store your element as WebElement
                WebElement SelectRange = driver.findElement(By.xpath("//a[(text()='" + Miles.get(i) + "')]"));
                actions.moveToElement(SelectRange).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to select a Range. " + e);
            }//end of select a range exception

            try {
                //store your element as WebElement
                WebElement search = driver.findElement(By.xpath("//*[@id='searchLocations']"));
                actions.moveToElement(search).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on search button. " + e);
            }//end of click on search

            Thread.sleep(2000);
            try {
                ArrayList <WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//div[@class='list-item-location popover-trigger']")));
                //actions.moveToElement(links.get(0)).click().perform();
                if (i==0) {
                    links.get(0).click();
                }else if (i==1) {
                    links.get(1).click();
                }else  {
                    links.get(2).click();
                }

            } catch (Exception e) {
                System.out.println("No result found  " + e);
            }

            try {
                //store your element as WebElement
               String daddress = driver.findElement(By.xpath("//*[@class=' address-wrapper']")).getText();
                System.out.println("Post Office address is: " + daddress);
            } catch (Exception e) {
                System.out.println("Unable to locate the address. " + e);
            }


            try {
                //store your element as WebElement
                String dhours = driver.findElement(By.xpath("//*[@class='hours-flex-section']")).getText();
                System.out.println("Operating Hours: " +dhours);
            } catch (Exception e) {
                System.out.println("Unable to find and capture the location hours. " + e);
            }//try/catch
            System.out.println("______________________");// just to separate each iteration
        }//end of loop
    }//end of main method
}//end of java class






