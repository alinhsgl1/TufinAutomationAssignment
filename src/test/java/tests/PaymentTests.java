package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ProductsPage;
import pageobjects.YourCardPage;
import pageobjects.YourInformationPage;
import utils.Excel;


public class PaymentTests extends  BaseTest{

    @Test(dataProvider = "getDataFromExcel", description = "payment")
    public  void tc03_payment(String firstName, String lastName, String zipCode){
        ProductsPage psp = new ProductsPage(driver);
        psp.openCart();

        YourCardPage ycp = new YourCardPage(driver);
        ycp.checkout();

        YourInformationPage yip = new YourInformationPage(driver);
        yip.fillInformation(firstName, lastName, zipCode);
        yip.fillInformationBtn();
    }

    @DataProvider
    public Object[][] getDataFromExcel(){
        String excelPath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\input.xlsx";
        System.out.println(excelPath);
        Object[][] table = Excel.getTableArray(excelPath, "Payment");
        return table;
    }
}
