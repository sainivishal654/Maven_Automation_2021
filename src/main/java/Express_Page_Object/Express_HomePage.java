package Express_Page_Object;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions;
import Reusable_library.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_HomePage extends Abstract_Class {

    //we have to declare a local logger so we can use it on the page
    ExtentTest logger;
    public Express_HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    //define all the WebElement you need using @FindBy concept
    @FindBy(xpath = "//*[@class='_3tHVp']")
    WebElement popup;
    @FindBy(xpath = "//a[text()='Men']")
    WebElement mentab;
    @FindBy(xpath = "//a[text()='Sweatshirts & Hoodies']")
    WebElement swtandhodies;

    //Create a method for closing pop up
    public void closePopup(){
        Reusable_Actions_PageObject.closePopupIfExist(driver,popup,logger,"Pop-Up");
    }//end of closing popup

    //Create a method to hover over men's tab
    public void HoverOverMenSection(){
        Reusable_Actions_PageObject.mouseHover(driver,mentab,logger,"Men's Tab");
    }//end of hover over method

    //Create a method to click on Sweatshirt and Hoodies
    public void clickonSweatshirtAndHoodies(){
        Reusable_Actions_PageObject.clickOnElement(driver,swtandhodies,logger,"SweatShirt and Hoodies");
    }//end of hover over method







}//end of java class
