package Day11_041021_TestNG;

import Day9_040321.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class mlcalc_TestNG {
    //declare your global variables
    WebDriver driver = null;
    WritableWorkbook writableWorkbook = null;
    WritableSheet writableSheet = null;
    int rowCount = 0;

    //setup your driver on before suite
    @BeforeSuite
    public void preconditions() throws IOException, InterruptedException, BiffException, IOException, BiffException {
        //set the driver using reusable method
        driver = Reusable_Methods.defineTheDriver();

        //Step1: locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_DataDriven.xls"));

        //Step 2: create a writable workbook that will mimic the data from readable
        writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_DataDriven_Result_TestNG.xls"),readableBook);

        //Ste3 : read everything from writable sheet
        writableSheet = writableWorkbook.getSheet(0);

        //Step 4: get the row count
        rowCount = writableSheet.getRows();
    }//end of preconditions

    @Test
    public void testScenario() throws WriteException, InterruptedException, WriteException, IOException {
        //this is where the for loop will start to iterate through your excel data
        for(int i =1; i <rowCount; i++) {

            //columns are hard coded and row is dynamic(i)
            String pPrice = writableSheet.getCell(0, i).getContents();
            String dPayment = writableSheet.getCell(1, i).getContents();
            String mTerm = writableSheet.getCell(2, i).getContents();
            String iRate = writableSheet.getCell(3, i).getContents();
            String stMonth = writableSheet.getCell(4, i).getContents();
            String stYear = writableSheet.getCell(5, i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);
            //enter the purchase price
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='ma']", pPrice, "Purchase Price");
            //enter the down payment
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='dp']", dPayment, "Down Payment");
            //enter mortgage term
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='mt']", mTerm, "Mortgage Term");
            //enter interest rate
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='ir']", iRate, "Interest Rate");
            //select start month
            Reusable_Methods.dropdownByText(driver, "//select[@name='sm']", stMonth, "Start Month");
            //select start year
            Reusable_Methods.dropdownByText(driver, "//select[@name='sy']", stYear, "Start Year");
            //click on Calculate
            Reusable_Methods.clickOnElement(driver, "//input[@value='Calculate']", "Calculate");

            //capture monthly payment
            String monthlyPayment = Reusable_Methods.captureText_Index(driver, "//td[@class='big']", 0, "Monthly Payment");

            //create a label so you can add it to a cell
            Label label = new Label(6, i, monthlyPayment);
            //add the label back to the sheet
            writableSheet.addCell(label);

        }//for loop: when working with excel the int i start with 1.
    }//end of test scenario



    @AfterSuite
    public void closeWorkbook() throws IOException, WriteException {
        //outside of the cell write back to writable workbook
        writableWorkbook.write();
        //close it
        writableWorkbook.close();

        //open writable excel automatically
        //Desktop.getDesktop().open(new File("src/main/resources/Mlcalc_DataDriven_Result.xls"));
    }//end of close work book
}//end of java class
