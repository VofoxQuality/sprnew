package SPR.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_data_config {

	XSSFWorkbook wb;
	XSSFSheet sh;

	public Excel_data_config(String excel_path) {
		try {
			File src = new File(excel_path);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

		}
	}

	public String getdata(int sheet_no, int row_no, int col_no) {

		sh = wb.getSheetAt(sheet_no);
		String data = sh.getRow(row_no).getCell(col_no).getStringCellValue();
		return data;
	}

	public int row_count(int sheet_index) {

		int row = wb.getSheetAt(sheet_index).getLastRowNum();
		row = row + 1;
		return row;
	}

}
