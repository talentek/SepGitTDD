package Utilities;

import java.io.IOException;

import org.testng.annotations.Test;

public class RunExcelTest {

	@Test
	public void myTest() throws IOException {

		// ReadExcelData.readExcel("D:\\Software-Testing-Training\\Excel-Test-Files\\Book1.xlsx",
		// "Sheet1");

		String[][] test;
		test = ReadExcelData.readExcel("D:\\Software-Testing-Training\\Excel-Test-Files\\Book1.xlsx", "Sheet1");

		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.println(test[i][j]);
			}
			System.out.println();
		}

	}

}
