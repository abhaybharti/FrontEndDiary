package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicWebTable {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","E:\\Work\\Projects\\FrontEndDiary\\Java\\src\\main\\resources\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://toolsqa.com/automation-practice-table");
            String sRow = "1";
            String sCol = "2";

            //Get the table
            WebElement webTable = driver.findElement(By.xpath("//table[contains(@class,'tsc_table_s13')]"));

            //Get the row count
            List<WebElement> listOfRows = webTable.findElements(By.tagName("tr"));

            System.out.println("Rows: "+listOfRows.size());

            //Get the column count
            List<WebElement> listOfCols = listOfRows.get(0).findElements(By.tagName("th")); //If first row is header row

            System.out.println("Columns: "+listOfCols.size());

            for (int i =2; i <listOfRows.size();i++){
                for (int j =1; j<listOfCols.size();j++){
                    //traverse each row/column & read data from cell using getText() method
                    System.out.println(driver.findElement(By.xpath("//table[contains(@class,'tsc_table_s13')]/thead/tr["+i+"]/th["+j+"]")).getText());
                }
            }

        /*    //Here we are locating the xpath by passing variables in the xpath
            String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
            System.out.println(sCellValue);
            String sRowValue = "Clock Tower Hotel";*/

            /*//First loop will find the 'ClOCK TWER HOTEL' in the first column
            for (int i=1;i<=5;i++){
                String sValue = null;
                sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
                if(sValue.equalsIgnoreCase(sRowValue)){
                    // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                    for (int j=1;j<=5;j++){
                        String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
                        System.out.println(sColumnValue);
                    }
                    break;
                }
            }*/
            driver.close();
        }
}
