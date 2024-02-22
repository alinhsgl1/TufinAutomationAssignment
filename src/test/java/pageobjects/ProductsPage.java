package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "#shopping_cart_container")
    private WebElement cartBtn;

    @FindBy(css = ".inventory_item")
    private List<WebElement> list;

    @FindBy(css = ".inventory_item_name")
    private WebElement titleEl;

    @FindBy(css = ".btn_inventory")
    private WebElement addBtn;

    @FindBy(css = ".title")
    private WebElement titleLabel;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseProduct(String name) {
        List<WebElement> list = this.driver.findElements(By.cssSelector(""));
        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            WebElement el = (WebElement)var3.next();
            if (el.getText().equalsIgnoreCase(name)) {
                this.click(el);
                break;
            }
        }
    }

    public void goToCard(){
        click(cartBtn);
    }

    public void addToCard(String name){
        List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
        for(WebElement el :list){
            WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
            if(getText(titleEl).equalsIgnoreCase(name)){
                WebElement addBtn = el.findElement((By.cssSelector(".btn_inventory")));
                click(addBtn);
                break;
            }
        }
    }

    public void openCart() {
        click(cartBtn);
    }
    public boolean isProductPage(){
        if(getText(titleLabel).equalsIgnoreCase("Products")){
            return  true;
        }
        return  false;
    }
}
