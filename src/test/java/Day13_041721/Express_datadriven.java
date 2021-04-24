package Day13_041721;

import Day9_040321.Reusable_Methods;
import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_datadriven extends Abstract_Class {
    @Test
         public void Express_Report() throws BiffException, IOException, InterruptedException, WriteException {

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
            Reusable_Actions.closePopupIfExist(driver, "//*[@class='_3tHVp']", logger,"closepop");
        }
        //hover over men's section
        Reusable_Actions.mouseHover(driver,"//a[text()='Men']", logger,"Men's Section");
        Thread.sleep(2000);
        //click on sweatshirts and Hoodies
        Reusable_Actions.Hover_Click(driver,"//a[text()='Sweatshirts & Hoodies']", logger,"Sweatshirt and Hoodies");
        Thread.sleep(2000);
        //click on sweaters
        Reusable_Actions.Hover_Click(driver,"//a[text()='Sweaters']", logger,"Sweaters");
        //click on First sweater
        Reusable_Actions.Hover_ClickBYIndex(driver,"//*[@class='_3TJgM']",0,logger,"First Sweatshirt");
        //Select size
            Reusable_Methods.Hover_Click(driver,"//*[text()='"+size+"']","Size");
        //add to bag
        Reusable_Actions.Hover_Click(driver,"//*[text()='Add to Bag']", logger,"Add to Bag");
        Thread.sleep(1500);
        //view bag
        Reusable_Actions.Hover_Click(driver,"//a[text()='View Bag']",logger,"View Bag");
        //change quantity
        Thread.sleep(1500);
        Reusable_Actions.dropdownByText(driver,"//*[@id='qdd-0-quantity']",quantity,logger,"Quantity");
        //Checkout
        Reusable_Actions.Hover_Click(driver,"//button[@class='btn _9yfmt _194FD _2tFXQ _1s_-v']",logger,"Checkout");
        //checkout as Guest
        Reusable_Actions.Hover_Click(driver,"//*[text()='Checkout as Guest']",logger,"Checkout as Guest");
        //enter First Name
        Reusable_Actions.sendKeysMethod(driver,"//input[@name='firstname']",fName,logger,"First Name" );
        //enter Last Name
        Reusable_Actions.sendKeysMethod(driver,"//*[@name='lastname']",lName,logger,"Last Name" );
        //enter email address
        Reusable_Actions.Hover_Click_Send_BYIndex(driver,"//input[@name='email']",0,email,logger,"Email Address" );
        //confirm email addres
        Reusable_Actions.Hover_Click_Send_BYIndex(driver,"//input[@aria-label='Confirm Email Address']",0,email,logger,"Email Address" );
        //enter phone number
        Reusable_Actions.Hover_Click_Send_BYIndex(driver, "(//input[@name='phone'])",0, phone,logger,"Phone");
        //click on continue
        Reusable_Actions.Hover_Click(driver, "//button[contains(@class,'btn _9yfmt')]", logger,"Continue");
        Thread.sleep(1500);
        //Select country
        Reusable_Actions.dropdownByText(driver,"//select[@name='shipping.countryCode']","United States",logger,"Country");
        //enter street address
        Reusable_Actions.sendKeysMethod(driver,"//input[@name='shipping.line1']",stAddress,logger,"Street address");
        //enter zipcode
        Reusable_Actions.sendKeysMethod(driver,"//input[@name='shipping.postalCode']",zipcode,logger,"postal Code");
        //enter shipping city
        Reusable_Actions.sendKeysMethod(driver,"//input[@name='shipping.city']",city,logger,"Shipping City");
        //select state
        Reusable_Actions.dropdownByText(driver,"//select[@name='shipping.state']",state,logger,"State");
        //click on continue button
        Reusable_Actions.Hover_Click(driver, "//button[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", logger,"Continue");
        Thread.sleep(3000);
        //confirm shipping method
        Reusable_Actions.Hover_Click(driver, "//span[text()='Continue']", logger,"Confirm shipping method");
        //enter credit card number
        Reusable_Actions.sendKeysMethod(driver,"//input[@id='creditCardNumberInput']",ccNo,logger,"Credit Card Number");
        //select exp Month
        Reusable_Actions.dropdownByText(driver,"//select[@name='expMonth']",expMonth,logger,"Exp Month");
        //Select exp Year
        Reusable_Actions.dropdownByText(driver,"//select[@name='expYear']",expYear,logger,"Exp Year");
        //type cvv
        Reusable_Actions.sendKeysMethod(driver,"//input[@name='cvv']",cvcode,logger,"CVV Number");
        Thread.sleep(2500);
        //place order
        Reusable_Actions.Hover_Click(driver, "//*[text()='Place Order']", logger,"Place Order");
        //capture error message
        String errorMessage = Reusable_Actions.CaptureText(driver,"//div[@class='xnY7x notification']",logger,"Error Message");
            logger.log(LogStatus.INFO, "Error message: " + errorMessage);
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


