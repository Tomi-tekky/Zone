import com.aventstack.extentreports.Status;
import com.zone.base.BaseTest;
import com.zone.pages.LandingPage;
import com.zone.utils.ConfigReader;
import com.zone.utils.RandomDataGenerator;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.zone.pages.LandingPage.*;


public class LambdaTest extends BaseTest {
    Properties testConfigs = ConfigReader.loadProperties(System.getProperty("user.dir") +"/src/test/resources/config.properties");

    private LandingPage landingPage;

    @BeforeMethod
    public void setUpTest() {
        test = extent.createTest("ClickShopByCategory");
    }


    @Test
    public void EcommerceAutomation() throws InterruptedException {
        landingPage = new LandingPage(getDriver());


        // Generate random test data
        String randomFirstname = RandomDataGenerator.getRandomString("John", 1000);
        String randomLastname = RandomDataGenerator.getRandomString("Doe", 1000);
        String randomEmail = RandomDataGenerator.getRandomEmail("example.com");
        String randomPhone = RandomDataGenerator.getRandomPhoneNumber();



        // Print the random data for debugging or logs
        System.out.println("Random Username: " + randomFirstname);
        System.out.println("Random Username: " + randomLastname);
        System.out.println("Random Email: " + randomEmail);
        System.out.println("Random Phone: " + randomPhone);




        // Test Data
        String url = testConfigs.getProperty("url");
        //String Firstname = testConfigs.getProperty("firstname");
        //String Lastname = testConfigs.getProperty("lastname");
        //String Email = testConfigs.getProperty("email");
        //String Phone = testConfigs.getProperty("phone");
        String Password = testConfigs.getProperty("password");


        logger.info("Opening: " + url);
        getDriver().get(url);
        Thread.sleep(3000);

        //Action to click on Shop Category
        landingPage.clickShopByCategory(LandingPage.ShopByCategory);
        Assert.assertTrue(LandingPage.ShopByCategory.isDisplayed());
        Thread.sleep(2000);
        test.log(Status.INFO, "Clicked on Shop By Category");
        test.log(Status.PASS, "Test completed successfully.");

        //Action to select MP3 player
        Assert.assertTrue(SelectMP3Player.isDisplayed());
        landingPage.clickOnMP3Player(SelectMP3Player);
        Thread.sleep(2000);
        test.log(Status.INFO, "Clicked on MP3 Player");
        test.log(Status.PASS, "Test completed successfully.");

        //Action to hover over menu
        landingPage.scroll(getDriver());
        landingPage.hoverOverMenu();
        landingPage.hoverAndClickSubmenu();
        Thread.sleep(2000);
        test.log(Status.INFO, "Hover over element and added wishlist");
        test.log(Status.PASS, "Test completed successfully.");

        //Action to Register
        landingPage.clickRegister();
        Thread.sleep(2000);


        //Fill form details
        Assert.assertTrue(firstname.isDisplayed());
        landingPage.inputFirstname(randomFirstname);
        Assert.assertTrue(lastname.isDisplayed());
        landingPage.inputLastname(randomLastname);
        Assert.assertTrue(email.isDisplayed());
        landingPage.inputEmail(randomEmail);
        Assert.assertTrue(telephone.isDisplayed());
        landingPage.inputTelephone(randomPhone);
        Assert.assertTrue(password.isDisplayed());
        landingPage.inputPassword(Password);
        Assert.assertTrue(ConfirmPassword.isDisplayed());
        landingPage.ConfirmPassword(Password);
        landingPage.clickAgree();
        landingPage.clickContinue();
        Thread.sleep(3000);
        Assert.assertTrue(Continue2.isDisplayed());
        landingPage.clickContinue2();
        test.log(Status.INFO, "Clicked on Register");
        test.log(Status.PASS, "Test completed successfully.");
    }

}
