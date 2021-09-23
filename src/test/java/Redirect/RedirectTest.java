package Redirect;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.RedirectPage;
import pages.StatusCodePage;
import pages.StatusCodesPage;

import static org.testng.Assert.*;

public class RedirectTest extends BaseTest {

    @Test
    public void TestRedirect(){
        RedirectPage redirect = homepage.clickRedirect();
        redirect.redirectMessage();
        assertEquals(redirect.redirectMessage(),"Redirection");
        StatusCodePage statusCodePage = redirect.clickHereRedirectLink();
        statusCodePage.redirectMessage();
        assertEquals(statusCodePage.redirectMessage(),"Status Codes");
        StatusCodesPage statusCodesPage = statusCodePage.clickHereRedirectLink();
        statusCodesPage.redirectMessage();
        assertTrue(statusCodesPage.redirectMessage().contains("200 status code"));

    }
}
