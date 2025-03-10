package sauce_Labs_Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sauce_Labs_TestBase.Sauce_Labs_BaseTest;

public class ExcelUtils extends Sauce_Labs_BaseTest {  private static final String FILE_PATH = "ItemList.xlsx";

public static void writeListToExcel(String sheetName, List<String> dataList) {
    Workbook workbook;
    Sheet sheet;

    try {
        File file = new File(FILE_PATH);
        
        // Create a new workbook if file doesn't exist
        if (file.exists()) {
            workbook = WorkbookFactory.create(file);
        } else {
            workbook = new XSSFWorkbook();
        }

        // Get or create the sheet
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        // Write data to sheet
        for (int i = 0; i < dataList.size(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                row = sheet.createRow(i);
            }
            Cell cell = row.getCell(0);
            if (cell == null) {
                cell = row.createCell(0);
            }
            cell.setCellValue(dataList.get(i));
        }

        // Save the file
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
        }
        System.out.println("Data successfully written to Excel file!");

    } catch (IOException e) {
        e.printStackTrace();
    }
}}
