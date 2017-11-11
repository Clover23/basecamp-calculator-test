import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class WiniumCalcTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void start() throws MalformedURLException {
        String bugUrl="C:\\Users\\Home\\Desktop\\GL\\CalculatorTC\\Calculator_exec_b2\\Calculator.exe";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", bugUrl);
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), cap);
        wait = new WebDriverWait(driver, 30);

    }

    @Test
    public void addititonTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("57", driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void subtractionTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));
        driver.findElement(By.name("7")).click();
        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("-")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("7")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("11", driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void multiplicationTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("*")).click();
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("0")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("210", driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void divisionTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("/")).click();
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("0")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("5.2", driver.findElement(By.id("1000")).getText());
    }

    @AfterClass
    public static void stop() {

        driver.quit();
    }
}
