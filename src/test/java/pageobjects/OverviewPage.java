package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage{

    @FindBy(css = ".summary_subtotal_label")
    private WebElement subTotalLabel;

    @FindBy(css = ".summary_total_label")
    private WebElement totalLabel;

    @FindBy(css = ".summary_tax_label")
    private WebElement taxLabel;

    @FindBy(css = ".cart_button")
    private WebElement finishBtn;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public  void finish(){
        click(finishBtn);
    }

    public double getSubTotalLabel() {
        double subtotal = Double.parseDouble(getText(subTotalLabel).replace("Item total: $", "")) ;
        double expectedTotal = round(subtotal * 1.08, 2); // Adding 8% tax and rounding
        return expectedTotal;

    }

    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    public String getTotalLabel() {
        return getText(totalLabel).replace("$", "");
    }
}
