import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start(){
        driver = new ChromeDriver();
        driver.get("C:\\Users\\Home\\Desktop\\GL\\automation\\calc.html");
    }

    @Before
    public void cleanup(){
        driver.findElement(By.cssSelector("input[type='button'][value='C']")).click();
}

    @Test
    public void addInt() {
        driver.findElement(By.cssSelector("input[type='button'][value='7']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='1']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='+']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='8']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='9']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='=']")).click();

        Assert.assertEquals("160", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void multiplyInt(){
        driver.findElement(By.cssSelector("input[type='button'][value='5']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='2']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='x']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='6']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='3']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='=']")).click();

        Assert.assertEquals("3276", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void divideInt(){
        driver.findElement(By.cssSelector("input[type='button'][value='4']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='8']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='/']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='2']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='4']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='=']")).click();

        Assert.assertEquals("2", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void subtractInt(){
        driver.findElement(By.cssSelector("input[type='button'][value='8']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='0']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='-']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='1']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='1']")).click();
        driver.findElement(By.cssSelector("input[type='button'][value='=']")).click();

        Assert.assertEquals("69", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @AfterClass
    public static void stop(){
        driver.quit();
    }
}

