package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage extends Utils {
    public WebDriver driver;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement HomeMenu;
    @FindBy(xpath = "//button[@id=\"currency\"]")
    WebElement CurrencyButton;
    @FindBy(xpath = "//ul[@aria-labelledby=\"currency\"]/li")
    List<WebElement> CurrencyDropDown;
    @FindBy(xpath = "//button[normalize-space()='English']")
    WebElement Lang;
    @FindBy(xpath = "//ul[@aria-labelledby='languages']")
    WebElement LangDD;
    @FindBy(xpath = "//a[normalize-space()='Arabic']")
    WebElement Arabic;
    @FindBy(xpath = "//button[@id=\"cookie_stop\"]")
    WebElement GotItButton;
    @FindBy(xpath = "//a[@class=\"theme-btn theme-btn-small waves-effect\"]")
    WebElement SignupButton;
    @FindBy(xpath = "(//a[text()=\"Company \"])[1]")
    WebElement CompanyButton;
    @FindBy(xpath = "//div[@class=\"main-menu-content\"]//li[@class=\"footm\"]//ul[@class=\"dropdown-menu-item\"]/li")
    List<WebElement> CompanyDropdown;


    public void clickHome() {
        HomeMenu.click();
    }

    public boolean verifyHomeMenu() {
        boolean flag = false;
        if (HomeMenu.isDisplayed()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void clickUSD() {
        CurrencyButton.click();
    }
    public void clickSignup(){
        SignupButton.click();
    }
    public boolean isListOfCurrenciesVisible() {
        return areDisplayed(CurrencyDropDown);
    }

    public void clickLang() {
        Utils.holdExecutionForSeconds(2);
        Lang.click();
    }

    public void getLang() {
        String s = LangDD.getText();
    }

    public WebElement clickArabic() {
        Utils.holdExecutionForSeconds(2);
        Arabic.click();
        return null;
    }
    public void acceptCookie(){
        GotItButton.click();
    }

    public boolean langIsDisplayed() {
        boolean flag = false;
        if (isDisplayedElement(Arabic.getText())) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public void hoverOnCompanyButton() {
        hover(CompanyButton);
    }

    public boolean valuesOfCompanyDropdownAreDisplayed() {
        return areDisplayed(CompanyDropdown);
    }

    public void clickOnAboutUsValueInCompanyDropdown() {
        click(CompanyDropdown.get(0));
        holdExecutionForSeconds(2);
    }

    public void clickOnTermsOfUseValueInCompanyDropdown() {
        click(CompanyDropdown.get(1));
        holdExecutionForSeconds(2);
    }

    public void clickOnFAQValueInCompanyDropdown() {
        click(CompanyDropdown.get(2));
        holdExecutionForSeconds(2);

    }
    }

