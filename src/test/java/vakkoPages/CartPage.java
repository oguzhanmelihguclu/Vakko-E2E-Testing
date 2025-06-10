package vakkoPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    WebDriver driver;
    Logger logger = Logger.getLogger(CartPage.class);

    @FindBy(xpath = "//*[text()=' Sepeti Onayla ']")
    private WebElement basketConfirm;


}
