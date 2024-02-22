package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;


public class AddProductsTest_Hardcoded extends  BaseTest {

    //Log into the page with user of “standard_user” and password of “secret_sauce”
    @Test
    public void tc01_login() {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");
    }

    //Add the bike light and the onesie to your cart.
    @Test
    public void tc02_addProducts() {
        ProductsPage psp = new ProductsPage(driver);
        psp.addToCard("Sauce Labs Bike Light");
        psp.addToCard("Sauce Labs Onesie");
    }

    //Go to the shopping cart.
    @Test
    public  void tc03_payment(){
        ProductsPage psp = new ProductsPage(driver);
        psp.openCart();

        YourCardPage ycp = new YourCardPage(driver);
        ycp.checkout();

        YourInformationPage yip = new YourInformationPage(driver);
        yip.fillInformation("a", "a", "111");
        yip.fillInformationBtn();
    }

    //Validate the total sum is correct
    @Test
    public  void tc04_validateTotalSum(){

        OverviewPage op = new OverviewPage(driver);
        //String expected = "Total: 19.42" ;
        String expected = "Total: " + op.getSubTotalLabel() ;
        String actual = op.getTotalLabel();
        Assert.assertEquals(actual, expected);
        //System.out.println(expected);
        op.finish();
    }

    //Validate that you got a Success message
    @Test
    public  void tc05_validateMessage(){
        FinishPage fp = new FinishPage(driver);
        String expected = "Thank you for your order!";
        String actual = fp.getFinishMsg();
        Assert.assertEquals(actual, expected);
    }
}





