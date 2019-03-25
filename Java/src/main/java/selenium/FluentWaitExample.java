package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/***
 ************ Implicit Wait **************************
 1. Once you set implicit wait, it will be applicable for all findElemnt() and findElements() method. There is no need to write implicit wait code
    again and again.
 2. If we set implicit wait as 30 seconds, It will be applicable to all web element to be located by WebDriver.
 3. When searching for a single element, the driver should poll the page until the element has been found, or this timeout expires before throwing
    a NoSuchElementException. When searching for multiple elements, the driver should poll the page until at least one element has been found or this
    timeout has expired.
 4. If you write implicit wait statement multiple times, time specified in latest implicit wait statement will be applicable. For example: You specify
    implicit wait as 30 seconds at line no 5 and another implicit wait as 60 seconds at line no 10, then implicit wait as 30 seconds will be applicable
    from line no 6-9 and implicit wait for 60 seconds will be applicable from line no 11 onward.
 5. Selenium WebDriver does not provide any direct getter method to retrieve implicit wait time. But you can create your own methods to retrieve it.
 6. It is good practice to define implicit wait in the beginning of the program when we create WebDriver reference variable.
 7. The default setting is Zero. Once set, the implicit wait is set for the life of the WebDriver object instance.
 8. Increasing the implicit wait timeout should be used judiciously as it will have an adverse effect on test run time, especially when used with
    slower location strategies like XPath.
 9. If you use the implicit wait in selenium it applies to the web driver globally and increases the execution time for the entire script. so it is
    not always advisable.
 10. You can not wait till some specific condition is satisfied like invisibility of element, when alert is present etc.

 */

public class FluentWaitExample {
    public static  void main(String args[]){
        //FluentWait webDriverWait = new

        System.setProperty("webdriver.chrome.driver","E:\\Work\\Projects\\FrontEndDiary\\Java\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //syntax
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        
        driver.manage().window().maximize();

        // Loading a URL
        driver.get("https://www.redbus.in/");
        // Locating and typing in From text box.
        WebElement fromTextBox= driver.findElement(By.id("src"));
        fromTextBox.sendKeys("Ban");
        // setting implicit time
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Wait starts:"+new Date());
        System.out.println("Typed Ban");
        // Clicking on first search result
        driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
        System.out.println("Selected Bangalore");
        System.out.println("Wait ends:"+new Date());
        //Closing browser
        driver.quit();
        System.out.println("browser closed");
    }
}
