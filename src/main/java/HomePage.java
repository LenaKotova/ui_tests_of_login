import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public final By avatarFullName = By.xpath("//*[@class=\"avatar-full-name\"]");

    public String getAvatarFullName() {
        return driver.findElement(avatarFullName).getText();
    }
}
