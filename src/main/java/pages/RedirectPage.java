package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectPage {
    private WebDriver driver;
    private By redirectHeading = By.xpath("//div[@class='example']/h3");
    private By hereButton = By.linkText("here");

    public RedirectPage(WebDriver driver){
        this.driver = driver;
    }

    public StatusCodePage clickHereRedirectLink(){
        driver.findElement(hereButton).click();
        return new StatusCodePage(driver);
    }

    public String redirectMessage(){
        return driver.findElement(redirectHeading).getText();
    }
}
