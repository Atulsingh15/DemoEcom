package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class excel {
    public static void main(String[] args) throws IOException {
        FileInputStream exce = new FileInputStream(System.getProperty("user.dir") + "/src/test/Selenium.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(exce);

        XSSFSheet sheet = book.getSheet("Sheet1"); // Get sheet
        XSSFRow row = sheet.getRow(1); // Get first row (index 0)
        XSSFCell password = row.getCell(1); // Get second column (index 1)
        XSSFCell id =row.getCell(0);
        

        System.out.println("Data from Row 1, Column 2: " + id.toString());
        System.out.println("Data from Row 1, Column 2: " + password.toString());
        

        book.close();
        exce.close();
    }
}
