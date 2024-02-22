package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FinishPage;
import pageobjects.OverviewPage;

public class ValidateTests extends  BaseTest{
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

    @Test
    public  void tc05_validateMessage(){
        FinishPage fp = new FinishPage(driver);
        String expected = "Thank you for your order!";
        String actual = fp.getFinishMsg();
        Assert.assertEquals(actual, expected);
    }

}
