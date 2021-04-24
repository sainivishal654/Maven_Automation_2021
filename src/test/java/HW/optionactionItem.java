package HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class optionactionItem {
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
        driver.manage().window().maximize();

//variables
        ArrayList <String> zipcode = new ArrayList<>();
        zipcode.add("08109");
        zipcode.add("08002");
        zipcode.add("08003");

        int[] x = new int[3];
        x[0] = 13;
        x[1] = 40;
        x[2] = 109;

        int[] y= new int[3];
        y[0] = 53;
        y[1] = 80;
        y[2] = 149;

//loop

        for (int i=0; i< zipcode.size(); i++) {

            try {
                driver.navigate().to("https://www.aetna.com");
            } catch (Exception e) {
                System.out.println("Unable to navigate to aetna. " + e);
            }//end of navigate exception
            Thread.sleep(2000);

            //verify the title with your expected
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Aetna")) {
                System.out.println("Title matches: " + actualTitle);
            } else {
                System.out.println("Your Title didn't match. The correct title is: " + actualTitle + ".");
            }


            Actions actions = new Actions(driver);


            try {
                //store your element as WebElement
                WebElement shop = driver.findElement(By.xpath("//li[@class='megamenu__primary--item']"));
                //move your mouse actions to shop  from dropdown to appear

                actions.moveToElement(shop).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to shop. " + e);
            }//end of send exception
            Thread.sleep(500);

            try {
                //store your element as WebElement
                WebElement med = driver.findElement(By.xpath("//button[text() ='Medicare']"));
                //move your mouse actions to medicare  from dropdown to appear

                actions.moveToElement(med).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to med. " + e);
            }//end of send exception
            Thread.sleep(500);

            try {
                //store your element as WebElement
                WebElement findDoctor = driver.findElement(By.xpath("//a[@data-analytics-name='Find a doctor']"));
                //move your mouse actions to find dr  from dropdown to appear

                actions.moveToElement(findDoctor).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to find a doctor. " + e);
            }//end of send exception
            Thread.sleep(2000);

            try {
                //store your element as WebElement
                WebElement guest = driver.findElement(By.xpath("//*[text()='2021 Medicare plans you purchase yourself']"));
                actions.moveToElement(guest).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to 2021 plan for yourself. " + e);
            }//end of send exception
            Thread.sleep(2000);

            try {
                //store your element as WebElement
                WebElement guest = driver.findElement(By.xpath("//*[@aria-labelledby='medZipHeading']"));
                actions.moveToElement(guest).click().sendKeys(zipcode.get(i)).perform();
            } catch (Exception e) {
                System.out.println("Unable to type zipcode. " + e);
            }//end of send exception

            Thread.sleep(2000);
            try {
                //store your element as WebElement
                WebElement guest = driver.findElement(By.xpath("//a[@tabindex='-1']"));
                actions.moveToElement(guest).click().perform();
            } catch (Exception e) {
                System.out.println("zipcode input not found. " + e);
            }//end of send exception
            Thread.sleep(2000);


            try {
                //store your element as WebElement
                WebElement slider = driver.findElement(By.xpath("//*[@class='rz-pointer rz-pointer-min']"));
                actions.dragAndDropBy(slider,x[i],y[i]).click().perform();
                //actions.clickAndHold();
               // actions.moveByOffset(x[i],y[i]);

            } catch (Exception e) {
                System.out.println("Unable to slide the slider, check your coordinates. " + e);
            }//end of send exception

            Thread.sleep(2000);
            try {
                //store your element as WebElement
                WebElement skip = driver.findElement(By.xpath("//*[@class='primaryPurple BtnWidth col-md-6 col-xs-12']"));
                actions.moveToElement(skip).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to skip  " + e);
            }//end of send exception
            Thread.sleep(2000);

            try {
                //store your element as WebElement
                WebElement doctorSP = driver.findElement(By.xpath("//a[@tabindex='-1']"));
                actions.moveToElement(doctorSP).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on dr and sp  " + e);
            }//end of send exception

            Thread.sleep(2000);

            try {
                //store your element as WebElement
                WebElement primarycare = driver.findElement(By.xpath("//a[@class='mobileMarAdj anchorTagGuided']"));
                actions.moveToElement(primarycare).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on primarycare  " + e);
            }//end of send exception
            Thread.sleep(2000);

            try {
                //store your element as WebElement
                WebElement allprimarycare = driver.findElement(By.xpath("//div[@class='second-level-result-description']"));
                actions.moveToElement(allprimarycare).click().perform();
            } catch (Exception e) {
                System.out.println("allprimarycare link not found " + e);
            }//end of send exception
            Thread.sleep(9000);


            try {
                //store your element as WebElement
                WebElement name = driver.findElements(By.xpath("//*[@class='bold contentHeadFontSize nameFontForMobile']")).get(1);
                //move your mouse actions to send  from dropdown to appear
                String name1 = name.getText();
                String[] arrayResult = name1.split("column");
                System.out.println("Dr. " + arrayResult[1]);


                //System.out.println(name1);

            } catch (Exception e) {
                System.out.println("Unable to find dr  name  " + e);
            }//end of send exception

            try {
                //store your element as WebElement
                String address = driver.findElement(By.xpath("//*[@class='mobileFont14px dataGridPadding']")).getText();
                //move your mouse actions to send  from dropdown to appear
                System.out.println("Address: " + address);

            } catch (Exception e) {
                System.out.println("Unable to find dr address   " + e);
            }//end of send exception

            System.out.println("________________");

        }//for loop
    }//end of main method
}//end of java class
