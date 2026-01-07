package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

//    public static WebDriver createDriver() {
//        return new ChromeDriver();
//    }


    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--headless=new",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--window-size=1920,1080"
        );

        return new ChromeDriver(options);
    }
}