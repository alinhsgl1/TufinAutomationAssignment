package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import utils.Excel;


public class LoginTest extends BaseTest {

    @Test(dataProvider = "getDataFromExcel", description = "use correct information of login")
    public void tc01_login(String user, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.login(user, password);
    }

   /* @Test(dataProvider = "getDataFromExcel", description = "use incorrect information")
    public void tc02_loginFailed(String user,String password) {
        LoginPage lp = new LoginPage(driver);
        lp.login(user, password);
        String expected = "Epic sadface: Username is required";
        String actual = lp.getErrorMsg();
        Assert.assertEquals(actual, expected);
    }


    @Test(dataProvider = "getDataFromExcel", description = "use incorrect information")
    public void tc03_loginFailed(String user,String password) {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "");
        String expected = "Epic sadface: Password is required";
        String actual = lp.getErrorMsg();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getDataFromExcel", description = "use incorrect information")
    public void tc04_loginFailed(String user,String password) {
        LoginPage lp = new LoginPage(driver);
        lp.login(user, password);
        String expected = "Epic sadface: Username is required";
        String actual = lp.getErrorMsg();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getDataFromExcel", description = "use incorrect information")
    public void tc05_loginFailed(String user,String password) {
        LoginPage lp = new LoginPage(driver);
        lp.login(user, password);
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = lp.getErrorMsg();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getDataFromExcel", description = "use correct information")
    public void tc05_loginSucceed(String user,String password) {
        LoginPage lp = new LoginPage(this.driver);
        lp.login(user, password);
        ProductsPage pp = new ProductsPage(driver);
        Assert.assertTrue(pp.isProductPage());
    }
*/
    @DataProvider
    public Object[][] getDataFromExcel(){
        String excelPath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\input.xlsx";
        System.out.println(excelPath);
        Object[][] table = Excel.getTableArray(excelPath, "Login");
        return table;
    }
}
