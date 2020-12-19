package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterTestPage extends Page{

    @FindBy(id = "date") private WebElement dateField;
    @FindBy(id="submit")private WebElement submit;
    @FindBy(id="forWho")private WebElement forWhoSelectField;


    public RegisterTestPage(WebDriver webDriver){
        super(webDriver);
        driver.get(getPath()+"?command=RegisterTest");
    }
    public void setDate(String date){
        dateField.clear();
        dateField.sendKeys(date);
    }
    public void setForWho(String nameAndEmail){
        forWhoSelectField.sendKeys(nameAndEmail);
    }
    public ContactPage submitValid(){
        submit();
        return PageFactory.initElements(driver, ContactPage.class);
    }
    public void submitInvalid(){
        submit();
    }
    public void submit(){
        submit.click();
    }
    
}
