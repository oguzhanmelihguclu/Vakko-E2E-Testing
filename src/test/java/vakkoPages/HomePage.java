package vakkoPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='icon search-input']")
    private WebElement searchBoxButton;

    @FindBy (xpath = "//*[@class='search-input']")
    private WebElement searchBox;

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            By cookieButton = By.cssSelector("button#onetrust-accept-btn-handler");
            WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookie.click();
            logger.info("Çerez bildirimi kabul edildi.");
        } catch (TimeoutException e) {
            logger.warn("Çerez bildirimi bulunamadı veya zaten kapalı.");
        } catch (Exception e) {
            logger.error("Çerez bildirimi kapatılamadı: " + e.getMessage());
        }
    }

    public void goToHomePage() {
        try {
            driver.get("https://www.vakko.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            acceptCookies();
            logger.info("Vakko ana sayfası açıldı.");
        } catch (Exception e) {
            System.out.println("İlgili sayfa yüklenemedi..");
        }
    }

    public boolean isHomePageDisplayed() {
        boolean result = driver.getTitle().contains("Vakko");
        logger.info("Ana sayfa doğrulaması yapıldı. Başlık sonucu: " + result);
        return result;
    }

    public void searchProduct(String keywords) {

        try {
            searchBoxButton.click();
            searchBox.sendKeys(keywords);
            logger.info("Search box'ta " + keywords + "araması yapıldı");
        } catch (Exception e) {
            System.out.println("İlgili sitede arama yapılamadı");
        }
    }

    public void pressEnterSearchBox() {
        searchBox.sendKeys(Keys.ENTER);
        logger.info("ENTER'a basıldı");
    }

    public void clearSearchBox() {
        searchBox.clear();
    }




}
