package vakkoPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ProductPage {
    WebDriver driver;
    Logger logger = Logger.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By productList = By.xpath("//div[@class='product-item-content']");

    @FindBy(xpath = "//button[text()=' 38 ']")
    private WebElement otuzsekizBeden;

    @FindBy(xpath = "//*[@class='pdp-description']")
    private WebElement description;

    @FindBy(xpath = "//*[@class='pdp-title']")
    private WebElement title;

    @FindBy(xpath = "//*[@class='price']")
    private WebElement price;

    @FindBy(xpath = "//*[text()=' Sepete Ekle ']")
    private WebElement addCart;

    @FindBy (xpath = "//*[text()=' Sepete git ']")
    private WebElement basket;




    public void selectRandomProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle

        // Ürün listesinin en az 1 eleman içermesi bekleniyor
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productList, 0));

        List<WebElement> products = driver.findElements(productList);

        if (products.isEmpty()) {
            logger.error("Ürün listesi boş! Rastgele ürün seçilemiyor.");
            throw new NoSuchElementException("Ürün listesi bulunamadı.");
        }

        int index = new Random().nextInt(products.size());
        WebElement selected = products.get(index);

        logger.info("Random ürün seçiliyor. Index: " + index);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selected);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selected);

        ReusableMethods.wait(5);
    }




    public void selectOtuzsekizNumaraBeden() {

        otuzsekizBeden.click();

    }

    public String getProductName() {
        String name = title.getText();
        logger.info("Ürün adı: " + name);
        return name;
    }

    public String getProductDescription() {
        String desc = description.getText();
        logger.info("Ürün tanımı : " + desc);
        return desc;
    }

    public String getProductPrice() {
        String price1 = price.getText();
        logger.info("Ürün fiyatı: " + price1);
        return price1;
    }

    public void addToCart() {
        addCart.click();
        logger.info("Ürün sepete eklendi.");
    }

    public void  goToBasket(){
        basket.click();
    }




}




