package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Pages.Signup;
import Utils.Utils;
import automation.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class phpTravels {
    public WebDriver driver;
    BasePage basePage;
    HomePage homePage;
    Signup signup;

    @BeforeClass
    public void tearUp() {
        driver = SetUp.LaunchBrowser("chrome");
        driver.get("https://www.phptravels.net/");
        basePage= new BasePage(driver);
        homePage= new HomePage(driver);
        signup = new Signup(driver);
    }
    @Test (priority =1)
     public void Menu(){
        basePage.clickHome();
        basePage.verifyHomeMenu();
        Utils.holdExecutionForSeconds(1);
    }
    @Test (priority = 2)
      public void openCurrency(){
         basePage.clickUSD();
         Assert.assertTrue(basePage.isListOfCurrenciesVisible());
         Utils.holdExecutionForSeconds(2);
        }

    @Test (priority = 3)
    public void verifyLanguague(){
        basePage.clickLang();
        Utils.holdExecutionForSeconds(2);
        basePage.getLang();
    }
    @Test (priority = 4)
    public void logoDisplayed(){
        Assert.assertTrue(homePage.isLogoVisible());
    }
    @Test(priority = 5)
    public void VerifySignUpPage(){
        basePage.acceptCookie();
        basePage.clickSignup();
        Assert.assertTrue(signup.SignUpPageLoad());
        signup.enterSignupDetails();
        signup.selectCustomerFromDropdown();
        signup.clickOnSignupButtonOnSignupPage();
        Assert.assertTrue(signup.isLoginTextDisplayed());

    }

    @Test (priority = 6)
    public void LatestOnBlogVisible(){
        Assert.assertTrue(homePage.BlogDisplayed());
        Assert.assertTrue(homePage.LatestIsDisplayed());
        Utils.holdExecutionForSeconds(2);

            }
    @Test (priority = 7)
        public void hoverUSD(){
        homePage.hoverUSD();
    }
    @Test (priority = 8)
    public void verifyCompanydd(){
            basePage.hoverOnCompanyButton();
            Assert.assertTrue(basePage.valuesOfCompanyDropdownAreDisplayed());
        }





    @AfterClass
    public void tear(){

    driver.quit();
    }

}

