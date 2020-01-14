package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {
    public static final String EXCEL_FILE_LOCATION = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";

    private static FileInputStream fis;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    public static String sheetName;
    public static DataFormatter formatter = new DataFormatter(Locale.US);

    public ExcelUtil(String sheetName){
        this.sheetName = sheetName;
    }

    public static void loadExcel() {
        File file = new File(EXCEL_FILE_LOCATION);
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTitles(){
        if (sheet == null){
            loadExcel();
        }
        List<String> myList = new ArrayList<>();

        for (int i = 1 ; i < sheet.getLastRowNum()+1 ; i++)
        {
            row = sheet.getRow(i);
            String keyCell = formatter.formatCellValue(row.getCell(0));
            myList.add(keyCell);
        }
        return myList;
    }
}
