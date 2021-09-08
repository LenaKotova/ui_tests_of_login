import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ForgotPassPage forgotPassPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        forgotPassPage = new ForgotPassPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("CL_5")
    void openLoginPage() {
        String loginTitle = loginPage.getLoginHeadingText();
        Assert.assertEquals("Вход в систему", loginTitle);
    }

    @Test
    @DisplayName("CL_1")
    void loginIsCorrect() {
        loginPage.login("fominaelena", "z0K6CTQR");
        Assertions.assertEquals("Фомина Елена Сергеевна", homePage.getAvatarFullName());
    }

    @Test
    @DisplayName("CL_2")
    void loginIsInvalid() {
        loginPage.login("", "");
        Assertions.assertEquals("Неверные данные для авторизации.", loginPage.getAlertText());
        loginPage.acceptAlert();
        Assertions.assertEquals("Вход в систему", loginPage.getLoginHeadingText());
    }

    @Test
    @DisplayName("CL_4")
    void clickShowPassButton() {
        loginPage.clickShowPassButton();
        Assertions.assertEquals("text", loginPage.getPasswordInputType());
    }

    @Test
    @DisplayName(("CL_3"))
    void pressForgotPass() {
        loginPage.clickForgotPass();
        Assertions.assertEquals("Восстановление пароля", forgotPassPage.getForgotPassHeading());
    }
}