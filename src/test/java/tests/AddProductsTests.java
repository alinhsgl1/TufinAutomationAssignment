package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ProductsPage;
import utils.Excel;

public class AddProductsTests extends  BaseTest {

    @Test(dataProvider = "getDataFromExcel", description = "shopping cart")
    public void tc02_addProducts(String product1, String product2) {
        ProductsPage psp = new ProductsPage(driver);
        psp.addToCard(product1);
        psp.addToCard(product2);
    }

    @DataProvider
    public Object[][] getDataFromExcel(){
        String excelPath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\input.xlsx";
        System.out.println(excelPath);
        Object[][] table = Excel.getTableArray(excelPath, "Product");
        return table;
    }
}
