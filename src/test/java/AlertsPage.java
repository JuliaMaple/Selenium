import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {

    private final WebDriver webDriver;
    private final By textCancel = By.xpath("//span[contains(., 'Cancel')]");

    public AlertsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("https://demoqa.com/alerts");
    }


    public void ClickAlertAndAccept() {
        WebElement alertButton = webDriver.findElement(By.xpath("//button[@id = \"alertButton\"]"));
        alertButton.click();
        webDriver.switchTo().alert().accept();
    }

    public void ClickTimerAlertAndAccept() {
        WebElement alertTimerButton = webDriver.findElement(By.xpath("//button[@id = \"timerAlertButton\"]"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        alertTimerButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void ClickConfirmAlertAndAccept() {
        WebElement confirmAlertButton = webDriver.findElement(By.xpath("//button[@id = \"confirmButton\"]"));
        confirmAlertButton.click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean isEmpty() {
        return !webDriver.findElements(textCancel)
                .isEmpty();
    }
}
