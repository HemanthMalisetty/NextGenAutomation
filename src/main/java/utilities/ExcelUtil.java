package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

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

    public static Map<String, Map<String, String >> getMapData(){
        if (sheet == null){
            loadExcel();
        }
        Map<String, Map<String, String>> superMap = new HashMap<>();
        Map<String, String> myMap = new HashMap<>();

        for (int i = 1 ; i < sheet.getLastRowNum()+1 ; i++)
        {
            row = sheet.getRow(i);
            String keyCell = formatter.formatCellValue(row.getCell(0));
            int colNumber = row.getLastCellNum();
            for (int j = 1 ; j < colNumber ; j++){
                String value = formatter.formatCellValue(row.getCell(j));
                myMap.put(keyCell, value);
            }
            superMap.put("master", myMap);
        }
        return superMap;
    }
    public static String getValue(String key){
        Map<String, String> myVal = getMapData().get("master");
        return myVal.get(key);
    }
    public static Set<String> getKeySet(){
        Map<String, String> myVal = getMapData().get("master");
        return myVal.keySet();
    }
}
