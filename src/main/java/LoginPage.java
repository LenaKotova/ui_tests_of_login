import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginHeading = By.xpath("//*[@class=\"info-title\"]");
    private final By loginField = By.xpath("//*[@name=\"user\"]");
    private final By passField = By.xpath("//*[@name=\"password\"]");
    private final By showPassButton = By.xpath("//*[@id=\"show_password\"]");
    private final By loginButton = By.xpath("//*[@id=\"button_submit_login_form\"]");
    private final By forgotPassLink = By.xpath("//*[@class=\"mira-default-login-page-link\"]");


    public String getLoginHeadingText() {
        return driver.findElement(loginHeading).getText();
    }

    public void enterLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    public void enterPass(String pass) {
        driver.findElement(passField).sendKeys(pass);
    }


    public void login(String login, String pass) {
        this.enterLogin(login);
        this.enterPass(pass);
        driver.findElement(loginButton).submit();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickShowPassButton() {
        driver.findElement(showPassButton).click();
    }

    public String getPasswordInputType() {
        return driver.findElement(passField).getAttribute("type");
    }

    public void clickForgotPass() {
        driver.findElement(forgotPassLink).click();
    }

}
