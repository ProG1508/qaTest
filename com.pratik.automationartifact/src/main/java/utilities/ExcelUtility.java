package utilities;

import java.io.FileInputStream;
import java.io.File;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	private Workbook workbook;
    private Sheet sheet;

    // Constructor
    public ExcelUtility(String excelPath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File("F:\\Selenium Projects\\Project2\\com.pratik.automationartifact\\src\\test\\resources\\testdata.xlsx"));
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get row count
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Get column count (based on first row)
    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    // Get cell data
    public String getCellData(int rowNum, int colNum) {
        try {
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
