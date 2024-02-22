package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage {
    @FindBy(css = ".complete-header")
    private WebElement completeHeader;

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    //validation message
    public String getFinishMsg() {
        return getText(completeHeader);
    }
}

