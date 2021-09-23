package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
    private WebDriver driver;
    private By statusCodeHeading = By.xpath("//div[@class='example']/p");

    public StatusCodesPage(WebDriver driver){
        this.driver = driver;
    }

    public String redirectMessage(){
        return driver.findElement(statusCodeHeading).getText();
    }

}
