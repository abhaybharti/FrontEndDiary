package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShotExample {
    public static  void main(String args[]){
        System.out.println("Exection starts");
        System.setProperty("webdriver.chrome.driver","E:\\Work\\Projects\\FrontEndDiary\\Java\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // file name where image to be saved
        String screenshotpath = "E:\\google.png";
        try {
            // save image to drive
            FileUtils.copyFile(scrFile, new File(screenshotpath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
