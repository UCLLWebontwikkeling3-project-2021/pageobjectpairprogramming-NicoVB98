package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{
    
    @FindBy(id="userId") private WebElement userIdField;
    @FindBy(id="password") private WebElement passwordField;

    @FindBy(id="date") private WebElement dateField;
    @FindBy(id="hour") private WebElement timeField;
    @FindBy(id="spaceship") private WebElement spaceshipField;
    @FindBy(id="phone") private WebElement phoneField;

    @FindBy(id="loginButton") private WebElement loginButton;
    @FindBy(id="addTripButton") private WebElement addTripButton;

    @FindBy(css="#login h4")private WebElement loginText;
    @FindBy(css="#logout input")private WebElement logoutButton;

    public HomePage(WebDriver webDriver){
        super(webDriver);
        driver.get(getPath());
    }
    public boolean isLoggedIn(){
        return loginText.getText().contains("Welcome");
    }
    public void logout(){
        logoutButton.click();
    }
    public void setUserId(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void setDate(String date) {
        dateField.clear();
        dateField.sendKeys(date);
    }
    public void setTime(String time) {
        timeField.clear();
        timeField.sendKeys(time);
    }
    public void setPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }
    public void setSpaceship(String spaceship) {
        spaceshipField.sendKeys(spaceship);
    }
    public void login(){
        loginButton.click();
    }
    public void addTrip(){
        addTripButton.click();
    }
    public String getUserIdFieldValue(){
       return userIdField.getAttribute("value") ;
    }

}
