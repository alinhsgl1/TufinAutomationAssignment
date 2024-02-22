package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCardPage extends BasePage{

    @FindBy(css = ".checkout_button")
    private WebElement checkoutBtn;

    public YourCardPage(WebDriver driver) {
        super(driver);
    }

    public void checkout() {
        click(checkoutBtn);
    }
}
