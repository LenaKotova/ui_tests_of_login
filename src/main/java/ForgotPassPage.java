import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPage {
    private final WebDriver driver;

    public ForgotPassPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By forgotPassHeading = By.xpath("//*[@class=\"info-title\"]");

    public String getForgotPassHeading() {
        return driver.findElement(forgotPassHeading).getText();
    }
}
