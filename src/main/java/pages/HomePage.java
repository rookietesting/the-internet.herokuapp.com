package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuth(){
        clickLinkText("Form Authentication");
        LoginPage page = new LoginPage(driver);
        return page;
    }

    public DropDownPage clickDropDown(){
        clickLinkText("Dropdown");
        return new DropDownPage(driver);
    }

    public RedirectPage clickRedirect(){
        clickLinkText("Redirect Link");
        return new RedirectPage(driver);
    }

    private void clickLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
