import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomeWork {

    public static void main(String[] args) {

        exerciseThird();

    }

    private static void exerciseFirst() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = webDriver.findElement(By.xpath("//div/button[@id = \"doubleClickBtn\"]"));
        WebElement rightMouseButtonClick = webDriver.findElement(By.xpath("//div/button[@id = \"rightClickBtn\"]"));
        WebElement leftMouseButtonClick = webDriver.findElement(By.xpath("//button[text() = \"Click Me\"]"));

        new Actions(webDriver)
                .doubleClick(doubleClickButton)
                .contextClick(rightMouseButtonClick)
                .click(leftMouseButtonClick)
                .build()
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.id("doubleClickMessage")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.id("rightClickMessage")).isEmpty();
        boolean isHaveClickText = !webDriver.findElements(By.id("dynamicClickMessage")).isEmpty();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveClickText) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }

        webDriver.quit();
    }

    private static void exerciseSecond() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/alerts");

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));

        WebElement alertButton = webDriver.findElement(By.xpath("//button[@id = \"alertButton\"]"));
        WebElement timerAlertButton = webDriver.findElement(By.xpath("//button[@id = \"timerAlertButton\"]"));
        WebElement confirmAlertButton = webDriver.findElement(By.xpath("//button[@id = \"confirmButton\"]"));

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmAlertButton.click();
        webDriver.switchTo().alert().dismiss();

        boolean isHaveTextAfterConfirmAlert = !webDriver.findElements(By.xpath("//span[contains(., 'Cancel')]"))
                .isEmpty();

        if (isHaveTextAfterConfirmAlert) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }

        webDriver.quit();
    }

    private static void exerciseThird() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/browser-windows");

        WebElement webElement = webDriver.findElement(By.id("tabButton"));
        webElement.click();

        String demoWindowDescriptor = webDriver.getWindowHandle();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoWindowDescriptor);

        Iterator<String> iterator = handles.iterator();
        String newTab = iterator.next();

        webDriver.switchTo()
                .window(newTab);
        webDriver.get("https://google.com");

        webDriver.switchTo()
                .window(demoWindowDescriptor);

        webDriver.quit();
    }
}
