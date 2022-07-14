import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWorkPageObjectTests {

    private static WebDriver driver;
    private static ButtonsPage buttonsPage;
    private static AlertsPage alertsPage;
    private static BrowserWindowsPage browserWindowsPage;

    public static void main(String[] args) {

        setUp();
        alertsTests();
        driver.quit();
    }


    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        buttonsPage = new ButtonsPage(driver);
        alertsPage = new AlertsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    public static void clickButtonsTest() {
        buttonsPage.open();
        buttonsPage.DoubleClickButton("doubleClickBtn");
        buttonsPage.RightMouseButtonClick("rightClickBtn");
        buttonsPage.LeftMouseButtonClick();
        boolean isHaveDoubleClickText = buttonsPage.isEmpty("doubleClickMessage");
        boolean isHaveRightClickText = buttonsPage.isEmpty("rightClickMessage");
        boolean isHaveClickText = buttonsPage.isEmpty("dynamicClickMessage");

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveClickText) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }
    }

    public static void alertsTests() {
        alertsPage.open();
        alertsPage.ClickAlertAndAccept();
        alertsPage.ClickTimerAlertAndAccept();
        alertsPage.ClickConfirmAlertAndAccept();

        boolean isHaveTextAfterConfirmAlert = alertsPage.isEmpty();

        if (isHaveTextAfterConfirmAlert) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }
    }

    public static void SwitchToNewPageTest() {
        browserWindowsPage.open();
        browserWindowsPage.openOtherPageInNewTab("https://google.com");
        if (browserWindowsPage.atPage("Google")) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }

    }


}
