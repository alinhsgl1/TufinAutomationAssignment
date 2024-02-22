package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Utils u = new Utils();
        //driver.get(Utils.readProperty("url"));
        driver.get("https://sauceDemo.com");
    }
    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}

