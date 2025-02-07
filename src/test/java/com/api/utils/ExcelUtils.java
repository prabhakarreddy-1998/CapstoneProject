package com.api.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<String> readTranslations(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        List<String> translations = new ArrayList<>();
        
        // Start reading from row 1 (line 2) to skip header
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(0); // assuming translations are in the first column
                if (cell != null) {
                    translations.add(cell.getStringCellValue());
                }
            }
        }
        workbook.close();
        return translations;
    }
}
