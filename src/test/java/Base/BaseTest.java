package Base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private EventFiringWebDriver driver;
    //can be accessed by any class in the same package and by subclasses even if they are in another packages
    protected HomePage homepage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        driver.manage().window().maximize();

        homepage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot,new File("resources/Screenshots/"+result.getName() + ".png"));
        }
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homepage = new HomePage(driver);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
}
