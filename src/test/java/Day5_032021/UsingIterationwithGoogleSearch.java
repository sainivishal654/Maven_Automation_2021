package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingIterationwithGoogleSearch {
    public static void main(String[] args) throws InterruptedException {


        /** iterate through multiple cities on google search and print out the number each time **/

        //declare and define the array list
        String[] cities = new String[3];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Bronx";


        //set the System property of where the driver is located so you can use it
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //define the WebDriver with a variable to use
        WebDriver driver = new ChromeDriver();

        //your actual use case from start to end should go inside for/while loop for multiple iterations
        for(int i = 0; i < cities.length; i++) {

            //navigate/get to google home page
            driver.navigate().to("https://www.google.com");

            //maximize the driver
            driver.manage().window().maximize();

            //sleep statement to let the page load completely
            Thread.sleep(800);

            //enter the keyword on google search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);
            Thread.sleep(800);
            //hit submit on google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //new page appears so put additional wait
            Thread.sleep(800);

            //capture the search result but only print out the search number
            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //split and extract out the search number
            String[] arrayResults = searchResult.split(" ");
            //print the search number
            System.out.println("The city is " + cities[i] +" and" + " search number is " + arrayResults[1] + " :)") ;
        }//end of for loop
        //quit the driver
        driver.quit();
    }//end of main method

}//end of java class
