package pages;


import org.openqa.selenium.By;
import utilities.DriverHelper;

import java.util.ArrayList;
import java.util.List;

public class NextGenAutomationLibrary {

    private String bookTitles = "//*[@id = 'title']";

    DriverHelper dh = new DriverHelper();

    public int getTotalDisplayedBooks(){
        dh.waitUntilPageLoads();
        return dh.findElements(bookTitles).size();
    }

    public List<String> getAllDisplayedBookTitles(int totalBooks){
        List<String> listOfBookTitles = new ArrayList<>();
        for (int i = 1; i <= totalBooks ; i++){

            listOfBookTitles.add(dh.getText("(" + bookTitles + ")[" + i +"]"));
        }
        return listOfBookTitles;
    }

    public int noOfFramesAvailable(){
        return dh.findElements(By.xpath("//iframe")).size();
        /*WebDriver driver = LocalDriverManager.getDriver();
        return driver.findElements(By.tagName("iframe")).size();*/
    }
}
