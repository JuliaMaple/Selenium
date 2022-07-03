import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ExampleWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://google.com");

        String googleWindowDescriptor = webDriver.getWindowHandle();

        ((ChromeDriver) webDriver).executeScript("window.open('about:blank')");

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(googleWindowDescriptor);

        Iterator<String> iterator = handles.iterator();
        String yandexWindowDescriptor = iterator.next();

        webDriver.switchTo()
                .window(yandexWindowDescriptor);
        webDriver.get("https:/yandex.ru");

        webDriver.switchTo()
                .window(googleWindowDescriptor);
        webDriver.switchTo()
                .window(yandexWindowDescriptor);
        webDriver.quit();

    }

}
