package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourInformationPage extends BasePage{
    @FindBy(css = "#first-name")
    private WebElement firstName;

    @FindBy(css = "#last-name")
    private WebElement lastName;

    @FindBy(css = "#postal-code")
    private WebElement zipCode;

    @FindBy(css = ".btn_action")
    private WebElement fillInfoBtn;

    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInformation(String fName, String lName, String zCode){
        fillText(firstName, fName);
        fillText(lastName, lName);
        fillText(zipCode, zCode);
        //click(fillInfoBtn);
    }
    public void fillInformationBtn() {
        click(fillInfoBtn);
    }
}
