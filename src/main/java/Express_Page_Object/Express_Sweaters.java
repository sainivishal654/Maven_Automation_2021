package Express_Page_Object;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Sweaters extends Abstract_Class {

    ExtentTest logger;
    public Express_Sweaters(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }// end of logger

    //define all the WebElement
    @FindBy(xpath = "//*[@class='_3TJgM']")
    WebElement firstsweater;
    @FindBy(xpath="//*[text()='M']")
    WebElement selectmsize;
    @FindBy(xpath = "//*[text()='Add to Bag']")
    WebElement addtobag;
    @FindBy(xpath = "//a[text()='View Bag']")
    WebElement viewbag;


    //create a method to click on the first sweater
    public void clickonFirstSweater(){
        Reusable_Actions_PageObject.clickOnElementByindex(driver,firstsweater,0,logger,"First Sweater");
    }//end of clicking on first sweater

    //Select medium size
    public void clickonMsize(){
        Reusable_Actions_PageObject.clickOnElement(driver,selectmsize,logger,"Size");
    }//end of clicking on first sweater

    //Add to bag
    public void clickonAddtoBag(){
        Reusable_Actions_PageObject.clickOnElement(driver,addtobag,logger,"Add to bag");
    }//end of of add to bag

    //view bag
    public void clickonViewbag(){
        Reusable_Actions_PageObject.clickOnElement(driver,viewbag,logger,"View Bag");
    }//end of of add to bag
}//end of java class
