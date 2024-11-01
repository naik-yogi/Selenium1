import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to selenium automation");
        final String URL = "https://www.tutorialspoint.com/selenium/practice/links.php";
        WebDriver driver = null;
        try {
            driver = launchBrowser("Chrome");
            System.out.println(openURL(driver, URL));
            clickLinks(driver);
        } catch (Exception e) {
            System.out.println("An error occured" + e.getMessage());
        } finally {
            quitDriver(driver);
        }

    }

    public static WebDriver launchBrowser(String browserName) {
        final String CHROME_DRIVER_PATH = "C:\\Users\\Yogesh Naik\\YOGESHNAIK\\Selenium\\Selenium Practice\\Selenium1\\src\\Drivers\\chromedriver.exe";
        final String EDGE_DRIVER_PATH = "C:\\Users\\Yogesh Naik\\YOGESHNAIK\\Selenium\\Selenium Practice\\Selenium1\\src\\Drivers\\msedgedriver.exe";
        WebDriver driver;
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;

            case "Edge":
                System.setProperty("webdriver.chrome.driver", EDGE_DRIVER_PATH);
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported broswer: " + browserName);
        }
        return driver;

    }

    public static String openURL(WebDriver driver, String URL) throws Exception {
        driver.get(URL);
        driver.manage().window().maximize();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("bo7dy")));
        return "URL is succesfully loaded";
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }

    }

    public static void clickLinks(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));
        System.out.println("Before click the title is: " + driver.getTitle());
        homeLink.click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Switch theme']")));

        driver.findElement(By.xpath("//span[text()='Switch theme']/parent::button")).click();
        System.out.println("Switched to dark mode successfully");

        WebElement loginButton = driver.findElement(By.xpath("//a[text()=\"Login\"]"));
        loginButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Sign In']")));

        System.out.println("After click the title is: " + driver.getTitle());
        driver.switchTo().window(mainWindow);
        System.out.println("Successfully switched back to main window");
        System.out.println("Main window totale is "+ driver.getTitle());
    }

}
