package Day9_040321;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = Reusable_Methods.defineTheDriver();

//navigate to google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2300);
//enter something on search field
        Reusable_Methods.sendKeysMethod(driver,"//*[@name='q']","Cars","Search Field");
//click on google search
        Reusable_Methods.clickOnElement(driver,"//*[@name='btnK']","Google Search");

    }//end of main
}//end of java class
