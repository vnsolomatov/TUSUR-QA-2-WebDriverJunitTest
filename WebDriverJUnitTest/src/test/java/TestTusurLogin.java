import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

@TestInstance(Lifecycle.PER_CLASS) //instead of modificator STATIC for methods with @AfterAll and @BeforeAll
public class TestTusurLogin {
	
	private WebDriver driver;
	
	@BeforeAll
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterAll
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void test() {
		driver.get("https://tusur.ru/");
		driver.manage().window().setSize(new Dimension(1038, 702));
		driver.findElement(By.linkText("Войти")).click();
		driver.findElement(By.id("user_email")).click();
		driver.findElement(By.id("user_email")).sendKeys("muv@2i.tusur.ru");
		//driver.findElement(By.cssSelector(".user_password")).click();
		driver.findElement(By.id("user_password")).click();
		driver.findElement(By.id("user_password")).sendKeys("123456");
		driver.findElement(By.cssSelector(".btn-big")).click();
		assertEquals(driver.findElement(By.cssSelector(".alert-alert")).getText(), "Неверный email или пароль.");
	}
}
