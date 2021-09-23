package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodePage {
    private WebDriver driver;
    private By twoHundretButton = By.linkText("200");
    private By statusCodesHeading = By.xpath("//div[@class='example']/h3");

    public StatusCodePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public StatusCodesPage clickHereRedirectLink(){
        driver.findElement(twoHundretButton).click();
        return new StatusCodesPage(driver);
    }

    public String redirectMessage(){
        return driver.findElement(statusCodesHeading).getText();
    }
}
