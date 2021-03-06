package TestCases;

import Pages.BasePage;
import Pages.HomePage;
import Utils.SetUp;
import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class Test<properties> {

    public WebDriver driver;

    HomePage homePage;
    BasePage basePage;

    @BeforeClass
    public void tearUp() {
        driver = SetUp.LaunchBrowser("chrome");
        homePage= new HomePage(driver);
        basePage= new BasePage(driver);
    }
    @BeforeMethod
    public void launchWebsite() {
        driver.get(basePage.properties.getProperty("url"));
    }

    @org.testng.annotations.Test(priority = 1)
    public void addToCart(){
        homePage.clickBuyNow();
        homePage.verifyTotal();
    }
    @org.testng.annotations.Test(priority = 2)
     public void clickBuyNoww(){
        homePage.verifyPrice();
        homePage.clickBuyNow();
        homePage.verifyCheckout();
    }
    @org.testng.annotations.Test(priority = 3)
    public void getDetails(){
        homePage.clickBuyNow();
        Utils.holdExecutionForSeconds(2);
        homePage.getCustomerDetails();

    }
    @AfterClass
    public void tear(){

        driver.quit();
    }

}
