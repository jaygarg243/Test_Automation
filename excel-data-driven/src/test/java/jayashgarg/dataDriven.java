package jayashgarg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	public ArrayList<String> getData(String testCase) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\jayas\\Desktop\\Selenium\\Excel Data Driven Test Sheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetNum = workbook.getNumberOfSheets();
		for(int i = 0;i<sheetNum;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("website_data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int k =0;
				int column = 0;
				while(cells.hasNext()) {
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Test")) {
						column = k;
					}
					k++;
			}
				System.out.println(column);
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCase)) {
						Iterator<Cell> c =  r.cellIterator();
						c.next();
						while(c.hasNext()) {
							Cell cell = c.next();
							if(cell.getCellType()==CellType.STRING) {
								a.add(cell.getStringCellValue());
							}
							else {
								a.add(NumberToTextConverter.toText( cell.getNumericCellValue()));
							}
						}
					}
				}
		}
		
	}
		return a;
	}
	public static void main(String[] args) throws IOException {
		
		
}}
