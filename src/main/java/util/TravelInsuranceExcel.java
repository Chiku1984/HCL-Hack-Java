package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TravelInsuranceExcel {
	public static Object[][] readData(String workBookName) {
		Object[][] data = null;

		try {
			File file = new File(workBookName);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum();
			System.out.println("Row Count: " + rowCount);

			// int cellCount = sheet.getRow(1).getLastCellNum();

			data = new Object[rowCount][1];

			for (int i = 0; i < rowCount; i++) {
				//int cellCount = sheet.getRow(i).getLastCellNum();

				for (int j = 0; j < 1; j++) {
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue().toString();
					System.out.println("in Excel - City: " + data[i][j]);
				}
			}

		} catch (FileNotFoundException fe) {
			System.out.println(" file not found: " + workBookName);
		} catch (IOException io) {
			System.out.println(" Input/Output error");
		}
		return data;

	}
}
