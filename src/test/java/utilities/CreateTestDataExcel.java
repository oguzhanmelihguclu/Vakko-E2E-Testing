package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestDataExcel {
	public static void main(String[] args) {
		Workbook workbook = new XSSFWorkbook();

		// Sheet1: Customer Kullanıcı Bilgileri
		Sheet sheet1 = workbook.createSheet("Sheet1");
		Object[][] userData = {
				{"Kullanıcı Adı", "Şifre"},
				{"oguzhanmguclu@gmail.com", "Test123456"}
		};

		// Veriyi sayfaya yaz
		populateSheet(sheet1, userData);

		// Excel dosyasını kaydet
		try (FileOutputStream fos = new FileOutputStream("src/test/java/datas/keywords.xlsx")) {
			workbook.write(fos);
			System.out.println("Excel dosyası başarıyla oluşturuldu: keywords.xlsx");
		} catch (IOException e) {
			System.err.println("Excel dosyası oluşturulurken hata meydana geldi: " + e.getMessage());
		}
	}

	private static void populateSheet(Sheet sheet, Object[][] data) {
		int rowCount = 0;
		for (Object[] rowData : data) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (Object field : rowData) {
				Cell cell = row.createCell(columnCount++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}
		}
	}
}
