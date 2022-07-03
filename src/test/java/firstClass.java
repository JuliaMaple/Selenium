import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class firstClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
//            webDriver.get("https://google.com");
        webDriver.get("http://the-internet.herokuapp.com");
        WebElement webElement = webDriver.findElement(By.xpath("//a[text() = 'Key Presses']"));
        webElement.click();
        webElement = webDriver.findElement(By.xpath("//input"));
        webElement.sendKeys("Hello");
        webDriver.close();
//        webDriver.quit();
    }
}