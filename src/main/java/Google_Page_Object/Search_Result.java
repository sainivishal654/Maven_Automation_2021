package Google_Page_Object;


import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Result extends Abstract_Class {

    //constructor is a method which uses the same name as java class
//to store information that you want to use locally to this class
//especially dealing with page object

    //declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Search_Result(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class


    //define all the WebElement you need using @FindBy concept
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement googleSearchResult;

    public void getSearchNumber(){
        String result = Reusable_Actions_PageObject.captureTextbyIndex(driver,googleSearchResult,0,logger,"Google Search Result Text");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.INFO,"Search number is " + arrayResult[1]);
    }//end of method

}//end of java class
