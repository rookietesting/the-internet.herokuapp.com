package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By message = By.xpath("//div[@class='flash success']");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String loggedInMessage(){
        return driver.findElement(message).getText();
    }
}
