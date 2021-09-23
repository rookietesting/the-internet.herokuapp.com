package Login;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homepage.clickFormAuth();
        loginPage.enterCredentials("tomsmith", "SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertEquals(secureAreaPage.loggedInMessage(),"You logged into a secure area!\n" + "×");
    }
}
