package Pages;

import automation.SetUp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.PublicKey;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class=\"logo\"]//img[@alt=\"logo\"]")
    WebElement logoOnTheBasePage;
    @FindBy(xpath = "//a[normalize-space()='Hotels']")
    WebElement HotelButton;
    @FindBy(xpath = "//a[normalize-space()='Flights']")
    WebElement FlightsButton;
    @FindBy(xpath = "//a[normalize-space()='Virgin Gorda beaches and lobste']")
    WebElement LatestonBlog;
    @FindBy(xpath = "//h2[normalize-space()='Latest on blogs']")
    WebElement BlogSection;
    @FindBy(xpath = "//strong[normalize-space()='USD 150']")
    WebElement PriceUSD150;
    @FindBy(xpath="//i[@title='Go top']")
    WebElement GoToTop;


    public boolean isLogoVisible() {
        boolean flag = logoOnTheBasePage.isDisplayed();
        return flag;
    }
    public boolean LatestIsDisplayed() {
        boolean flag = LatestonBlog.isDisplayed();
      return flag;
    }
    public boolean BlogDisplayed(){
       Boolean flag = BlogSection.isDisplayed();
        return flag;
    }
    public void hoverUSD(){
    Actions action = new Actions(driver);
    action.moveToElement(PriceUSD150).build().perform();
    }
    public void clickonReturn(){
       Actions action = new Actions(driver);
       action.moveToElement(GoToTop).click(GoToTop).perform();

    }
    public boolean returnClickDisplayed(){
        boolean flag= GoToTop.isDisplayed();
        return flag;
    }

}

