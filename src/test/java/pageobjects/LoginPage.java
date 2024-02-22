package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(css = "#user-name")
    private WebElement userField;

    @FindBy(css = "#password")
    private WebElement passField;

    @FindBy(css = "#login-button")
    private WebElement loginBtn;

    @FindBy(css = "[data-test='error']")
    private WebElement errorLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String password) {
        fillText(userField, user);
        fillText(passField, password);
        click(loginBtn);
    }

    //validation
    public String getErrorMsg() {
        return this.getText(this.errorLabel);
    }
}
