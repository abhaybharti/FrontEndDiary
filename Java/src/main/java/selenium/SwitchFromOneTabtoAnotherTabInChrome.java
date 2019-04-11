package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class SwitchFromOneTabtoAnotherTabInChrome {
    public static void main(String args[]) {

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
//        String availableText = driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).getText();
//        System.out.println("Text Available is :" + availableText);

        String windowHandle = driver.getWindowHandle();
        System.out.println("windowHandle : "+windowHandle);

        //driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL +"T");


        //Open a new tab
        String a = "window.open('https://yahoo.com','_blank');";
        ((JavascriptExecutor)driver).executeScript(a);
        System.out.println("Test Finished");

        Set<String> s1=driver.getWindowHandles();
        System.out.println(s1.size());

        for(String childWindow:s1) {
         //   if (!childWindow.equals(windowHandle))
            driver.switchTo().window(childWindow);
            System.out.println(driver.getCurrentUrl());
        }

       /* //For navigating right to left:
        Actions action= new Actions(driver);
        action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();

        //For navigation left to right
        action= new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();*/



    }
}
