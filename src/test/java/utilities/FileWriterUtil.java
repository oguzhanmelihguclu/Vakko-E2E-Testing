package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    private static final String FILE_PATH = "src/main/resources/data/urun-bilgisi.txt";

    public static void writeProductInfo(String name, String price) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write("Ürün Adı: " + name + "\n");
            writer.write("Ürün Fiyatı: " + price + "\n");
            writer.close();
            System.out.println("Ürün bilgisi başarıyla dosyaya yazıldı.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazılamadı: " + e.getMessage());
        }
    }
}
