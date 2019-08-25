package com.securepay.webauto.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import com.securepay.webauto.config.ConfigFileReader;
import com.securepay.webauto.data.BrowserType;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriverManager() {
        setDriverEnv();
    }

    public WebDriver getDriver(){
        ConfigFileReader configInstance = ConfigFileReader.getInstance();
        switch(BrowserType.valueOf(configInstance.getBrowserType().toUpperCase())){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case IE:
                driver = getIEWebDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }
        maximizeWindow();
        setImplicitelyWait(configInstance.getImplicitlyWait());
        setPageLoadTimeout(configInstance.getPageLoadTimeout());
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }

    private void setDriverEnv(){
        String driverType = ConfigFileReader.getInstance().getDriverType();
        String driverPath = ConfigFileReader.getInstance().getDriverPath();
        System.setProperty(driverType, driverPath);
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void setImplicitelyWait(int implicitlyWait){
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }

    private void setPageLoadTimeout(int pageloadTimeout){
        driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
    }

    private WebDriver getIEWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        options.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
        return new InternetExplorerDriver(options);
    }
}

