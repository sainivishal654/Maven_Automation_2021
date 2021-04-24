package HW;

import Day9_040321.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class ExpressActionItem {
    public static void main(String[] args) throws IOException, InterruptedException, BiffException, WriteException {

        //set the driver using reusable method
        WebDriver driver = Reusable_Methods.defineTheDriver();

        //Step1: locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ExpressShop.xls"));

        //Step 2: create a writable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ExpressShop_dd_result.xls"),readableBook);

        //Ste3 : read everything from writable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: get the row count
        int rowCount = writableSheet.getRows();

        //maximize the driver
        driver.manage().window().maximize();

        //this is where the for loop will start
        for(int i =1; i <=3; i++) {

            //columns are hard coded and row is dynamic(i)
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String fName = writableSheet.getCell(2, i).getContents();
            String lName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phone = writableSheet.getCell(5, i).getContents();
            String stAddress = writableSheet.getCell(6, i).getContents();
            String zipcode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String ccNo = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvcode = writableSheet.getCell(13, i).getContents();

            //navigate to express
            driver.navigate().to("https://www.express.com");
            Thread.sleep(1500);
            //close the popup
            if (fName.equals("Vishal")) {
                Reusable_Methods.Hover_Click(driver, "//*[@class='_3tHVp']", "closepop");
            }
            //hover over men's section
            Reusable_Methods.hoveroverElement(driver,"//a[text()='Men']", "Men's Section");
            Thread.sleep(2000);
            //click on sweatshirts and Hoodies
            Reusable_Methods.Hover_Click(driver,"//a[text()='Sweatshirts & Hoodies']","Sweatshirt and Hoodies");
            Thread.sleep(2000);
            //click on sweaters
            Reusable_Methods.Hover_Click(driver,"//a[text()='Sweaters']","Sweaters");
            //click on First sweater
            Reusable_Methods.Hover_ClickBYIndex(driver,"//*[@class='_3TJgM']",0,"First Sweatshirt");
            //Select size
            if(fName.equals("Vishal")) {
                Reusable_Methods.Hover_ClickBYIndex(driver, "//div[@class='_2ZSXl']", 1, "Size");
            }else if(fName.equals("Mak")){
                Reusable_Methods.Hover_ClickBYIndex(driver, "//div[@class='_2ZSXl']", 3, "Size");
            }else{
                Reusable_Methods.Hover_ClickBYIndex(driver, "//div[@class='_2ZSXl']", 2, "Size");
            }//end of selecting size

            //add to bag
            Reusable_Methods.Hover_Click(driver,"//*[text()='Add to Bag']","Add to Bag");
            Thread.sleep(1500);
            //view bag
            Reusable_Methods.Hover_Click(driver,"//a[text()='View Bag']","View Bag");
            //change quantity
            Thread.sleep(1500);
            Reusable_Methods.dropdownByText(driver,"//*[@id='qdd-0-quantity']",quantity,"Quantity");
            //Checkout
            Reusable_Methods.Hover_Click(driver,"//button[@class='btn _9yfmt _194FD _2tFXQ _1s_-v']","Checkout");
            //checkout as Guest
            Reusable_Methods.Hover_Click(driver,"//*[text()='Checkout as Guest']","Checkout as Guest");
            //enter First Name
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='firstname']",fName,"First Name" );
            //enter Last Name
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='lastname']",lName,"Last Name" );
            //enter email address
            Reusable_Methods.Hover_Click_Send_BYIndex(driver,"//input[@name='email']",0,email,"Email Address" );
            //confirm email addres
            Reusable_Methods.Hover_Click_Send_BYIndex(driver,"//input[@aria-label='Confirm Email Address']",0,email,"Email Address" );
            //enter phone number
            Reusable_Methods.Hover_Click_Send_BYIndex(driver, "(//input[@name='phone'])",0, phone,"Phone");
            //click on continue
            Reusable_Methods.Hover_Click(driver, "//button[contains(@class,'btn _9yfmt')]", "Continue");
            Thread.sleep(1500);
            //Select country
            Reusable_Methods.dropdownByText(driver,"//select[@name='shipping.countryCode']","United States","Country");
            //enter street address
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.line1']",stAddress,"Street address");
            //enter zipcode
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.postalCode']",zipcode,"postal Code");
            //enter shipping city
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.city']",city,"Shipping City");
            //select state
            Reusable_Methods.dropdownByText(driver,"//select[@name='shipping.state']",state,"State");
            //click on continue button
            Reusable_Methods.Hover_Click(driver, "//button[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", "Continue");
            Thread.sleep(2500);
            //confirm shipping method
            Reusable_Methods.Hover_Click(driver, "//span[text()='Continue']", "Confirm shipping method");
            //enter credit card number
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='creditCardNumberInput']",ccNo,"Credit Card Number");
            //select exp Month
            Reusable_Methods.dropdownByText(driver,"//select[@name='expMonth']",expMonth,"Exp Month");
            //Select exp Year
            Reusable_Methods.dropdownByText(driver,"//select[@name='expYear']",expYear,"Exp Year");
            //type cvv
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='cvv']",cvcode,"CVV Number");
            Thread.sleep(2500);
            //place order
            Reusable_Methods.Hover_Click(driver, "//*[text()='Place Order']", "Place Order");
            //capture error message
            String errorMessage = Reusable_Methods.captureText(driver,"//div[@class='xnY7x notification']","Error Message");
            //create a label so you can add it to a cell
            Label label = new Label(14,i,errorMessage);
            //add the label back to the sheet
            writableSheet.addCell(label);

            driver.manage().deleteAllCookies();

        }//end of for loop

        //outside of the cell write back to writable workbook
        writableWorkbook.write();
        //close it
        writableWorkbook.close();

    }//end of main method
}//end of java class
