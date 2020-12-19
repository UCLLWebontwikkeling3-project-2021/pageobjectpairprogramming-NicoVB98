import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public abstract class TestBasis {

    protected WebDriver driver;
    protected FirefoxOptions options;
    @Before
    public void setUp(){
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxProfile p=new FirefoxProfile();
        options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
        driver=new FirefoxDriver(options);
    }

    protected void loginAsAdmin(){
        HomePage page=PageFactory.initElements(driver, HomePage.class);
        page.setUserId("admin");
        page.setPassword("t");
        page.login();
    }
    protected String generateRandomUseridInOrderToRunTestMoreThanOnce(String component) {
        int random = (int)(Math.random() * 1000 + 1);
        return random+component;
    }
    @After
    public void clean(){
      driver.quit();
    }
    
}
