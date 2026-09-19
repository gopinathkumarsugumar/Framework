package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);

            // Start from row 1 to skip headers
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();

                data.add(new Object[]{username, password});
            }
        }

        return data.toArray(new Object[0][]);
    }
}
