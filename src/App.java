import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to selenium automation");
        WebDriver driver =launchBrowser("Edge");
        System.out.println(openURL(driver, "https://www.tutorialspoint.com/selenium/practice/links.php"));

    }

    public static WebDriver launchBrowser(String browserName) {
        WebDriver driver= null; 
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Yogesh Naik\\YOGESHNAIK\\Selenium\\Selenium Practice\\Selenium1\\src\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("Edge")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Yogesh Naik\\YOGESHNAIK\\Selenium\\Selenium Practice\\Selenium1\\src\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        return driver;

    }

    public static String openURL(WebDriver driver ,String URL) {
        driver.get(URL);
        driver.manage().window().maximize();
        driver.quit();
        return "URL is succesfully loaded";
    }

}
