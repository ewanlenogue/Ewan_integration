package tests;

import config.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    void login_failure() {
        loginPage.open();
        loginPage.login("admin", "wrong");

        Assertions.assertTrue(
                loginPage.isErrorDisplayed()
        );
    }
}
