import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {

    private final WebDriver webDriver;

    public ButtonsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("https://demoqa.com/buttons");
    }

    public void DoubleClickButton(String id) {
        WebElement button = webDriver.findElement(By.id(id));
        new Actions(webDriver)
                .doubleClick(button)
                .build()
                .perform();
    }

    public void RightMouseButtonClick(String id) {
        WebElement button = webDriver.findElement(By.id(id));
        new Actions(webDriver)
                .contextClick(button)
                .build()
                .perform();
    }

    public void LeftMouseButtonClick() {
        WebElement button = webDriver.findElement(By.xpath("//button[text() = \"Click Me\"]"));
        new Actions(webDriver)
                .click(button)
                .build()
                .perform();
    }

    public boolean isEmpty(String textMessage) {
        return !webDriver.findElements(By.id(textMessage)).isEmpty();
    }

}
