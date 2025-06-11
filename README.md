# Vakko E-Ticaret Sitesi Otomasyon Testi

Bu proje, Vakko'nun e-ticaret web sitesine yönelik temel bir kullanıcı senaryosunu otomasyon testiyle doğrulamak amacıyla hazırlanmıştır. Testler, **TestNG** test çatısı kullanılarak yazılmıştır ve **OpenJDK 23** üzerinde çalışmaktadır.

## 🔍 Test Senaryosu

Aşağıdaki kullanıcı davranışı otomasyon testi ile simüle edilmiştir:

1. Kullanıcı siteye login olur.
2. Arama çubuğuna **"ayakkabı"** kelimesini yazar.
3. Arama sonuçlarından rastgele bir ürün seçer.
4. Ürün detay sayfasında **38 numara** ayakkabıyı seçer.
5. Ürünü sepete ekler.
6. Sepet sayfasında listelenen ürün fiyatı ile ürün detay sayfasındaki fiyatın **aynı olduğunu doğrular**.

## 🛠 Kullanılan Teknolojiler

- **Java OpenJDK 23**
- **TestNG**
- **Selenium WebDriver**
- **Maven** (bağımlılık yönetimi ve proje derleme için)
- **WebDriverManager** (driver yönetimi için, opsiyonel)

## 📁 Proje Yapısı

```bash
vakko-automation-test/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── config/         # Konfigürasyon ve ayarlar  
│   │   │   ├── core/           # Temel framework bileşenleri  
│   │   │   ├── pages/          # Page Object Model sınıfları  
│   │   │   ├── utils/          # Yardımcı sınıflar (örn: Driver setup, veri yönetimi)  
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/          # Test sınıfları  
│   │   │   ├── runners/        # Test çalıştırıcıları (JUnit, TestNG vb.)  
│   │   │   ├── reports/        # Test raporları ve loglar  
├── resources/                   # Test verileri ve konfigürasyon dosyaları  
├── target/                      # Derleme çıktıları  
├── pom.xml                      # Maven yapılandırması  
├── README.md                    # Proje dokümantasyonu  
└── .gitignore                    # Git versiyon kontrolü için dosya hariç tutma  
                 # Maven yapılandırması
└── README.md
```

## ▶️ Testi Çalıştırmak

### Gereksinimler:
- Java 23 yüklü olmalı
- Maven yüklü olmalı

### Komut:

```bash
mvn clean test
```
