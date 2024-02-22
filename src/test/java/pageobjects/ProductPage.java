package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = ".btn_primary.btn_inventory")
    private WebElement cartBtn;

    @FindBy(css = ".inventory_details_back_button")
    private WebElement backBtn;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCard() {
        click(cartBtn);
    }

    public void back() {
        click(backBtn);
    }
}
