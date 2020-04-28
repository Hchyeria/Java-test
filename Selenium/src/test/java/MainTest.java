
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

class Driver {
    WebDriver driver = new ChromeDriver();
    Driver() {
        driver.get("http://103.120.226.190/selenium-demo/git-repo");
    }
}

@RunWith(Parameterized.class)
public class MainTest {
    private String userName;
    private String passWord;
    private static WebDriver driver = new Driver().driver;
    private WebElement un, pw, button;

    public MainTest(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Before
    public void setUp() {
        un = driver.findElement(By.cssSelector("input[name='user_number']"));
        pw = driver.findElement(By.cssSelector("input[name='password']"));
        button = driver.findElement(By.cssSelector("input[type='submit']"));
    }

    private static boolean isRowEmpty(Row row) {
        boolean isEmpty = true;
        DataFormatter dataFormatter = new DataFormatter();

        if (row != null) {
            for (Cell cell : row) {
                if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
                    isEmpty = false;
                    break;
                }
            }
        }

        return isEmpty;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        Collection<Object[]> res = new ArrayList<>();
        try (InputStream inp = new FileInputStream("src/test/resources/Selenium+Lab2020.xlsx")) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            for (Row r : sheet) {
                if (isRowEmpty(r)) {
                    continue;
                }
                Object[] list = new Object[2];
                int index = 0;
                for (Cell c : r) {
                    String s = c.getStringCellValue();
                    list[index++] = s;
                }
                res.add(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    private String test(String userName, String passWord) {

        un.sendKeys(userName);
        pw.sendKeys(passWord);

        button.submit();
        List<WebElement> code = driver.findElements(By.cssSelector(".mb-2 code"));
        return code.get(1).getText();
    }

    @Test
    public void main() throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(passWord, test(userName, passWord));
    }
}
