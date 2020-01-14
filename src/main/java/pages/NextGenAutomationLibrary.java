package pages;

import org.openqa.selenium.By;
import utilities.DriverHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextGenAutomationLibrary {

    private String parentFrame = "//*[@name = 'htmlComp-iframe']",
                    childFrame = "//iframe",
                    bookTitle = "//*[@id = 'titlehref']";

    DriverHelper dh = new DriverHelper();

    public List<String> getAllDisplayedBookTitles(){
        List<String> listOfBookTitles = new ArrayList<>();

        int noOfParentFrames = noOfParentFramesAvailable(), noOfChildFrames;

        for (int i = 1; i < noOfParentFrames; i++){
            dh.waitForFrameToBeAvailableAndSwitchToIt(By.xpath("(" + parentFrame +")[" + (i+1) + "]"));
            noOfChildFrames = noOfChildFramesAvailable();
            for (int j = 0; j < noOfChildFrames; j++){
                dh.waitForFrameToBeAvailableAndSwitchToIt(By.xpath("(//iframe)["+(j+1)+"]"));
                String title = dh.getAttribute(bookTitle, "title");
                listOfBookTitles.add(title);
                dh.switchToParentFrame();
            }
            dh.switchToDefaultContent();
        }
        Collections.sort(listOfBookTitles);
        return listOfBookTitles;
    }

    public int noOfParentFramesAvailable(){
        return dh.findElements(By.xpath(parentFrame)).size();
    }
    public int noOfChildFramesAvailable(){
        return dh.findElements(By.xpath(childFrame)).size();
    }
}
