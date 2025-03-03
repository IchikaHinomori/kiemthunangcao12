
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThemSanPhamVaoGioTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testThemSanPhamVaoGioVaDatBanh() {
        // 1. Mở trang web
        driver.get("https://www.savor.vn/");

        WebElement chonHaNoiButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".hover\\3A bg-slate-100:nth-child(1)")));
        chonHaNoiButton.click();
        //bắt đầu lỗi(sai inspector)
        WebElement themBanhMousseButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".min-w-0:nth-child(1) > .rounded-lg:nth-child(2) path")
        ));
        themBanhMousseButton.click();

        WebElement themBanhKemHoaTocButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#banh-kem-hoa-toc-1h .min-w-0:nth-child(1) > .rounded-lg > .items-center > .inline-flex:nth-child(2)"))); // Sửa locator
        themBanhKemHoaTocButton.click();

        WebElement banhV8846 = wait.until(ExpectedConditions.elementToBeClickable(By.id("V8846")));
        banhV8846.click();

        WebElement tiepTucButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".flex-col-reverse > .bg-primary-green-avocado-100")));
        tiepTucButton.click();
    }

}
