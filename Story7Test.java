import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.ContactPage;
import pages.HomePage;
import pages.RegisterTestPage;

public class Story7Test extends TestBasis{

    @Override
    public void setUp(){
        super.setUp();
        loginAsAdmin();
        addTrip();
    }
    @Test
    public void test_registerTestResult_showsTestResultInContactOverview(){
        RegisterTestPage rtp=PageFactory.initElements(driver, RegisterTestPage.class); 
        rtp.setDate("2020-03-02");
        rtp.setForWho("Ad Ministrator admin@email.com");
        ContactPage cp=rtp.submitValid();
        boolean found=cp.containsContactWithValues("15/03/2020","12:11","Ad Ministrator","odyssey","02/03/2020");
        assertTrue(found);
    }
    @Test
    public void test_registerTestResult_noDateGiven_givesError(){
        RegisterTestPage rtp=PageFactory.initElements(driver, RegisterTestPage.class);
        rtp.submitInvalid();
        assertTrue(rtp.hasErrorMessage("Please fill in a date"));
    }
    private void addTrip(){
        HomePage page=PageFactory.initElements(driver, HomePage.class);
        page.setDate("2020-03-15");
        page.setPhone("0497933310");
        page.setSpaceship("odyssey");
        page.setTime("12:11");
        page.addTrip();

    }
    
}
