package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String[][] readExcel(String fileName, String sheetName) throws IOException {

		File file = new File(fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook myWorkbook = new XSSFWorkbook(inputStream);
		Sheet myWorkSheet = myWorkbook.getSheet(sheetName);

		// Number of rows
		int rowCount = myWorkSheet.getLastRowNum();
		// Number of columns
		int columnCount = myWorkSheet.getRow(0).getLastCellNum();

		String inputData[][] = new String[rowCount][columnCount];
		DataFormatter formatter = new DataFormatter();

		for (int i = 0; i < rowCount; i++) {
			Row row = myWorkSheet.getRow(i+1);
			for (int j = 0; j < columnCount; j++) {

				//System.out.print(formatter.formatCellValue(row.getCell(j)) + "|| ");
				inputData[i][j] = formatter.formatCellValue(row.getCell(j));

			}

			myWorkbook.close();

		}

	return inputData;

	}
}
