package Learn.com.magento.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	 
	static DataFormatter df = new DataFormatter();
	static String path = System.getProperty("user.dir") + "\\resources\\TestData.xlsx";

	public static String getData(String key,String testcaseID) throws IOException {

		Map<String, String> getDtaFromExcel = setMapData(getCallingClassName(),testcaseID);
		return getDtaFromExcel.get(key);

	}
	//For common steps
	public static String getDataCommon(String key,String testcaseID,String sheetName) throws IOException {

		Map<String, String> getDtaFromExcel = setMapData(sheetName,testcaseID);
		return getDtaFromExcel.get(key);

	}


	public static Map<String, String> setMapData(String sheetName,String testCaseId) throws IOException {
		
		String getExcelSheet=sheetName.replace("Page", "").replace("Test", "").replace("Util", "");
		FileInputStream fis = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(getExcelSheet);

		if (sheet == null) {
			throw new RuntimeException("Sheet not found: " + getExcelSheet);
		}

		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
		Map<String, String> excelFileMap = new HashMap<>();

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row == null)
				continue;

			Cell cell = row.getCell(0);
			if (cell == null)
				continue;

			String firstColValue = df.formatCellValue(cell);
			if (firstColValue.contains(sheetName+"_"+testCaseId)) {
					for (int l = 0; l < row.getLastCellNum(); l++) {
					String key = df.formatCellValue(sheet.getRow(0).getCell(l));
					String val = df.formatCellValue(row.getCell(l));
					columnMapdata.put(key, val);
				}
				break; // found and done
			
		}
		}

		excelFileMap.putAll(columnMapdata);
		workbook.close();
		return excelFileMap;
	}
		public static String getCallingClassName() {
		// Get the calling class (caller of ExcelUtil)
		String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
		return fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
	}
}
