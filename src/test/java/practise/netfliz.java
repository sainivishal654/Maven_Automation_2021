package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class netfliz {
    public static void main(String[] args) throws InterruptedException {

String[] user,pass;

user = new String[1];
user[0]= "Annusaini1800@gmail.com";

pass = new String[1];
pass[0] = "90503512323";

        //set the path to the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to netflix
        driver.navigate().to("http://www.netflix.com");

        //fullpage
        driver.manage().window().maximize();

        //click on sign in
        WebElement signin = driver.findElement(By.xpath("//*[@href='/login']"));
        signin.click();
        Thread.sleep(2000);

        //fill in username
        WebElement usernam = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/form/div[1]/div/div/label/input"));
        //Select usr = new Select(usernam);
       // usernam.click();
        usernam.sendKeys(user[0]);

        //fill in pas

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.clear();
        password.sendKeys(pass[0]);

        WebElement clickSign= driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button"));
        clickSign.click();

        ///html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/div/a/div/div
        WebElement clickpr= driver.findElement(By.xpath("///html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/div/a/div/div"));
        clickpr.click();






    }//end of main method
}//end of class
