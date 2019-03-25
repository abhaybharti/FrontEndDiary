package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/***
 *   *********** GET() Method ***************
  1. get() method is declared in WebDriver interface.
  2. get() method is defined in RemoteWebDriver class.
  3. get() method returns void.
  4. get() method takes an argument of type String which is your AUT URL.
  5. It loads a new web page in the current browser window.
  6. It is done using an HTTP GET operation.
  7. It blocks the execution of next statement till web page is loaded completely.
  8. If you try to open a URL without http or https( e.g. driver.get(“www.facebook.com”);) , get() method will throw
     “org.openqa.selenium.WebDriverException“. It will also give error message as “Cannot navigate to invalid URL”.
  9. You can load a URL as http://facebook.com. It will not give any exception. Normally also it will load Facebook page. This was asked to me
     in interview. If you pass a wrong URL e.g. https://faceok.com , it will not give any page load time exception. Browser will display
     “ERR_CONNECTION_REFUSED” and program will be terminated.
  10. There is default page load time which is 300 seconds. It will throw  org.openqa.selenium.TimeoutException once default page load time reaches
      and page is still loading. If a URL is being loaded and you stop manually loading of URL by clicking on “Stop Loading Page” icon what will
      happen?? Nothing will happen and get() method will hold the control till default page load timeout reaches. You can’t make get() method fool.
      We can set page load time using pageLoadTimeout(long arg0, TimeUnit arg2) method. Syntax is as below:

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  11. You can not go back and forward using get() method. You can use get() multiple times in a program.

   *********** NAVIGATE() Method ***************
      Syntax: driver.navigate().to(“http://www.makeseleniumeasy.com”);
   1. navigate() is abstract method which allows the driver to access the browser’s history and to navigate to a given URL. It returns a
      WebDriver.Navigation that allows the selection of what to do next.
   2. It behaves in same way as get() method does.
   3. Using navigate() method we can go back and forward using back() and forward() methods respectively if any session presents.
   4. forward() method moves a single “item” forward in the browser’s history. Does nothing if we are on the latest page viewed.
   5. back() method moves back a single “item” in the browser’s history.
   6. Using navigate() method we can refresh the page by calling refresh() method on it.
   7. We can pass URL class object as well to to() method to open a URL. to() method is overloaded with arguments type of String and URL(java.net.URL).
        Syntax: driver.navigate().to(new URL(“http://www.google.com”))
 */

public class URLLoadingInSeleniumWebdriver {

    public static  void main(String args[]){

        //Example code for get() method
        //================================
        System.out.println("Exection starts");
        System.setProperty("webdriver.chrome.driver","E:\\Work\\Projects\\FrontEndDiary\\Java\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //loading URL
        driver.get("http://www.makeseleniumeasy.com");
        System.out.println("http://www.makeseleniumeasy.com -- loaded");
        driver.get("http://www.facebook.com");
        System.out.println("http://www.facebook.com -- loaded");

        //Setting default load page time out
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        driver.get("http://www.learn-automation.com");

        driver.quit();

        //Example code for navigate() method
        //==================================
        driver = new ChromeDriver();
        driver.navigate().to("http://www.makeseleniumeasy.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("http://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());



    }
}
