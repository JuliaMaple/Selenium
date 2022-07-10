import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowsPage {
    private final WebDriver webDriver;

    public BrowserWindowsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open(){
        webDriver.get("https://demoqa.com/browser-windows");
    }

    public WebElement findButton(String id) {
        return webDriver.findElement(By.id(id));
    }

    public void openOtherPageInNewTab(WebElement button, String newPage) {

        button.click();
        String demoWindowDescriptor = webDriver.getWindowHandle();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoWindowDescriptor);

        Iterator<String> iterator = handles.iterator();
        String newTab = iterator.next();

        webDriver.switchTo()
                .window(newTab);
        webDriver.get(newPage);

    }

    public boolean atPage(String titleOfPage) {
        return webDriver.getTitle().equals(titleOfPage);
    }

}
