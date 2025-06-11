package vakkoPages;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelReader;
import utilities.ReusableMethods;

import javax.swing.*;

public class LoginPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);
    ExcelReader excelReader = new ExcelReader("src/test/java/datas/keywords.xlsx");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();



    @FindBy(xpath = "(//*[@class='icon'])[3]")
    private WebElement profileButton;

    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailBox;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "(//*[text()=' Giriş Yap '])[2]")
    private WebElement girisYapButton;

    @FindBy(xpath = "//button[text()=' Çıkış Yap ']")
    private WebElement cikisYapButton;


    public void login() {

        try {
            profileButton.click();
            ReusableMethods.wait(2);
            emailBox.sendKeys(excelReader.getExcelText("Sheet1", 1, 0));
            ReusableMethods.wait(2);
            passwordBox.sendKeys(excelReader.getExcelText("Sheet1", 1, 1));
            ReusableMethods.wait(2);
            girisYapButton.click();
            logger.info("Kullanici login oldu.");
        } catch (Exception e) {
            System.out.println("Kullanici login olamadı..");
        }
    }

    public void logout() {
        profileButton.click();
        ReusableMethods.wait(2);
        cikisYapButton.click();
    }
}
