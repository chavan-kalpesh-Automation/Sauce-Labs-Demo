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

public class ExcelUtils extends Sauce_Labs_BaseTest {
    private static final String FILE_PATH = "ProductDetails.xlsx";

    public static void writeProductDetailsToExcel(String sheetName, List<List<String>> productData) {
        Workbook workbook;
        Sheet sheet;

        try {
            File file = new File(FILE_PATH);

            // Create a new workbook if file does not exist
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

            // Create header row if empty
            if (sheet.getPhysicalNumberOfRows() == 0) {
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Product Name");
                headerRow.createCell(1).setCellValue("Description");
                headerRow.createCell(2).setCellValue("Price");
            }

            // Write data to sheet
            int rowNum = sheet.getLastRowNum() + 1;
            for (List<String> product : productData) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(product.get(0)); // Product Name
                row.createCell(1).setCellValue(product.get(1)); // Description
                row.createCell(2).setCellValue(product.get(2)); // Price
            }

            // Save the file
            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }

            System.out.println("Product details successfully written to Excel file!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
