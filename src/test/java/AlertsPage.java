import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {

    private final WebDriver webDriver;

    public AlertsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("https://demoqa.com/alerts");
    }

    public WebElement findElement(String name) {
        return webDriver.findElement(By.id(name));
    }

    public void ClickAlertAndAccept(WebElement button) {
        button.click();
        webDriver.switchTo().alert().accept();
    }

    public void ClickTimerAlertAndAccept(WebElement button) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        button.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void ClickConfirmAlertAndAccept(WebElement button) {
        button.click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean isEmpty() {
        return !webDriver.findElements(By.xpath("//span[contains(., 'Cancel')]"))
                .isEmpty();
    }
}
