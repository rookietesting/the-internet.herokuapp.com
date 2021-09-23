package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigation;

    public WindowManager(WebDriver driver){
        this.driver = driver;
    }

    public void goBack(){
        navigation.back();
    }

    public void goToURL(String url){
        navigation.to(url);
    }
}
