package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Signup extends BasePage {

    public Signup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()=\"Signup\"]")
    WebElement SignUpButton;
    @FindBy(xpath = "//div[@class=\"modal-body\"]//div[@class=\"input-box\"]//input")
    WebElement SignUpDetails;
    @FindBy(xpath = "//select[@id=\"account_type\"]")
    WebElement Dropdown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SignupButton1;
    @FindBy(xpath = "//h5[text()=\"Login\"]")
    WebElement LoginText;

    public boolean SignUpPageLoad() {
        boolean flag = SignUpButton.isDisplayed();
        return flag;
    }
    public ArrayList detailsToBeEntered() {
        List<String> details = new ArrayList<>();
        details.add("Demo6");
        details.add("User6");
        details.add("112345678");
        details.add("abc6@gmail.com");
        details.add("abcde@123");
        return (ArrayList) details;
    }
    public void enterSignupDetails() {
        ArrayList<String> details = detailsToBeEntered();
        enterTextForListOfWebElements((List<WebElement>) SignUpDetails, details);

    }

    public void selectCustomerFromDropdown() {
        handleDropdownOfSelectTagUsingValue(Dropdown, "customers");
        holdExecutionForSeconds(2);
    }

    public void clickOnSignupButtonOnSignupPage() {
        scrollDown();
        click(SignupButton1);
        holdExecutionForSeconds(5);
    }

    public boolean isLoginTextDisplayed() {
         boolean flag= LoginText.isDisplayed();
         return flag;

    }

}