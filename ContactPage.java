package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends Page {
    @FindBy(id = "firstName") private WebElement firstNameField;
    @FindBy(id = "lastName") private WebElement lastNameField;
    @FindBy(id = "email") private WebElement emailField;
    @FindBy(id = "phone") private WebElement phoneField;
    @FindBy(id = "signUp") private WebElement submit;

    public ContactPage(WebDriver driver) {
        super(driver);
        driver.get(getPath() + "?command=Contacts");
    }

    public void setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void submit() {
        submit.click();
    }

    public boolean containsContactWithValues(String date, String time, String name, String spaceship,String covid) {
        List<WebElement> table = driver.findElements(By.cssSelector("tr:not(:first-child)"));
        for (WebElement we : table) {
            if (

                    we.getText().contains(spaceship) &&
                            we.getText().contains(name) &&
                            we.getText().contains(date) &&
                            we.getText().contains(time) &&
                            we.getText().contains(covid)
            ) {
                return true;
            }
        }
        return false;
    }

    public int getContactListCount() {
        return driver.findElements(By.cssSelector("tr:not(:first-child)")).size();
    }

    public String getFirstnameFieldValue() {
        return firstNameField.getAttribute("value");
    }

    public String getLastNameFieldValue() {
        return lastNameField.getAttribute("value");
    }

    public String getEmailFieldValue() {
        return emailField.getAttribute("value");
    }
    public String getPhoneFieldValue(){
        return phoneField.getAttribute("value");
    }
}
