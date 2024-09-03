package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelUtils {
	
	public static int totalRow;
	
	//create(new File(filePath));
	
	public List<Map<String, String>> getData(String filePath, String sheetName) throws IOException{
		
		XSSFWorkbook workbook= new XSSFWorkbook(filePath);
		XSSFSheet sheet = workbook.getSheet(sheetName);
			
			workbook.close();
		return readsheet(sheet);
		
	}
	
	
	private List<Map<String, String>> readsheet(XSSFSheet sheet){
		
		XSSFRow row;
		XSSFCell cell;
		totalRow=sheet.getLastRowNum();
		List<Map<String, String>> excelRow=new ArrayList<Map<String, String>>();
		for(int currentRow=1; currentRow<=totalRow; currentRow++) {
			 row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();
			Map<String, String> columnMapData= new LinkedHashMap<String, String>();
			for(int currentColumn=0; currentColumn <totalColumn; currentColumn++) {
				 cell = row.getCell(currentColumn);
				 String columnHeader = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
				 columnMapData.put(columnHeader, cell.getStringCellValue());
			}
			excelRow.add(columnMapData);
		}
		
		return excelRow;
		
	}
	public int countRow() {
		return totalRow;
	}
	
	public static void main(String[] args) throws IOException {
		ExcelUtils eu= new ExcelUtils();
		List<Map<String, String>> data = eu.getData("./src/test/resources/data/test.xlsx", "Sheet1");
		String value = data.get(2).get("UserName");
		String value1 = data.get(2).get("Password");
		System.out.println(value);
		System.out.println(value1);
		
		
	}
	
	
	
	/*
	 * XSSFWorkbook workBook = null; XSSFSheet sheet = null; XSSFRow row = null;
	 * XSSFCell cell = null; String value = null; List<String> li = new
	 * ArrayList<String>();
	 * 
	 * public List<String> readDataFromSheet(String filePath, int sheetNumber) { try
	 * {
	 * 
	 * workBook = new XSSFWorkbook(filePath); sheet =
	 * workBook.getSheetAt(sheetNumber); for (int i = 0; i <=sheet.getLastRowNum();
	 * i++) { row = sheet.getRow(i); for (int j = 0; j <
	 * sheet.getRow(0).getLastCellNum(); j++) { cell = row.getCell(j); DataFormatter
	 * dft = new DataFormatter(); System.out.println(dft.formatCellValue(cell));
	 * li.add(dft.formatCellValue(cell)); } } workBook.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return li; }
	 * 
	 * public static void main(String[] args) { ExcelUtils e= new ExcelUtils();
	 * List<String> value =
	 * e.readDataFromSheet("./src/test/resources/data/test.xlsx", 0);
	 * System.out.println(value);
	 * 
	 * }
	 */

}
