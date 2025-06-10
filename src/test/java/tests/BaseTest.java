package tests;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setup(){
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
