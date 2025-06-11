package tests;

import org.junit.Assert;
import utilities.ReusableMethods;
import vakkoPages.HomePage;
import vakkoPages.LoginPage;
import vakkoPages.ProductPage;
import org.junit.Before;
import org.junit.Test;

public class E2E extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Before
    public void setupPages() {
        // driver BaseTest'te oluşturulduktan sonra page nesneleri oluşturulmalı
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void E2Etest() {

        // kullanici anasayfayi acar
        homePage.goToHomePage();
        homePage.isHomePageDisplayed();

        // kullanici login olur
        loginPage.login();

        // tekrar ana sayfaya git
        homePage.goToHomePage();

        // arama butonuna "ayakkabı" yazar
        homePage.searchProduct("ayakkabı");
        homePage.pressEnterSearchBox();
        ReusableMethods.wait(3);

        // herhangi bir ürünü seçer
        productPage.selectRandomProduct();

        // 38 numara beden seçer
        productPage.selectOtuzsekizNumaraBeden();
        ReusableMethods.wait(2);

        // ürünü sepete ekler
        productPage.addToCart();
        ReusableMethods.wait(2);

        // sepete gider
        productPage.goToBasket();
        ReusableMethods.wait(2);


        // kullanici ürünün fiyatı ile sepetin fiyatını karsilastirir
        String priceStr = productPage.getProductPrice();
        double fiyat1 = productPage.parsePrice(priceStr);

        String priceStr2 = productPage.getProductBasketPrice();
        double fiyat2 = productPage.parsePrice(priceStr2);

        Assert.assertEquals(fiyat1, fiyat2, 0.01); // 0.01 fark toleransı



    }
}
