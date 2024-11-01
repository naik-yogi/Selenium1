import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yogesh Naik\\YOGESHNAIK\\Selenium\\Selenium Practice\\Selenium1\\src\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        // driver.wait(5000);
        System.out.println(driver.getTitle());
        List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links " + totalLinks.size());
        for (int i = 0; i < totalLinks.size(); i++) {
            System.out.println("Link text is: " + totalLinks.get(i).getText());
        }
        driver.quit();
    }
}
