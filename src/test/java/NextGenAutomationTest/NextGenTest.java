package NextGenAutomationTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NextGenAutomationLibrary;
import utilities.ExcelUtil;

import java.util.*;

public class NextGenTest extends BaseTest {
    @Test
    public void BookTitleValidations(){
        ExcelUtil excelUtil = new ExcelUtil("BookTitles");
        List<String> bookTitlesFromExcelSheet = excelUtil.getTitles();
        /*Iterator it = bookTitlesFromExcelSheet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/

        NextGenAutomationLibrary nextGen = new NextGenAutomationLibrary();
        List<String> bookTitlesFromApplication = nextGen.getAllDisplayedBookTitles();

        boolean equals = bookTitlesFromApplication.equals(bookTitlesFromExcelSheet);
        Assert.assertTrue(equals, "Book titles are not matching with excel sheet data");
    }
}