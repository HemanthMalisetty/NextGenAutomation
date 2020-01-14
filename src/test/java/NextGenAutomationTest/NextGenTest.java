package NextGenAutomationTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;
import pages.NextGenAutomationLibrary;

import java.util.List;

public class NextGenTest extends BaseTest {
    @Test
    public void BookTitleValidations(){

        BaseTest  baseTest = new BaseTest();
        baseTest.beforeMethod("chrome", "https://www.nextgenerationautomation.com/automation-library");


        NextGenAutomationLibrary nextGen = new NextGenAutomationLibrary();
        System.out.println(nextGen.noOfFramesAvailable());
        /*int noOfBooks = nextGen.getTotalDisplayedBooks();
        List<String> bookTitles = nextGen.getAllDisplayedBookTitles(noOfBooks);

        System.out.println(noOfBooks);
        System.out.println(bookTitles);*/

        baseTest.afterMethod();
    }
}
