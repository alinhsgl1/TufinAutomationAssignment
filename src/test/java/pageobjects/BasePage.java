package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    WebDriver driver;
    String mainWindow;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillText(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        el.click();
    }

    public String getText(WebElement el) {
        return el.getText();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }

    public void selectByValue(WebElement el, String value) {
        Select s = new Select(el);
        s.selectByValue(value);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void alertOK(String text) {
        this.driver.switchTo().alert().sendKeys(text);
        this.driver.switchTo().alert().accept();
    }

    public void alertOK() {
        this.driver.switchTo().alert().accept();
    }

    public void moveTomainWindow() {
        this.driver.close();
        this.driver.switchTo().window(this.mainWindow);
    }

    public void waiting(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }
}
