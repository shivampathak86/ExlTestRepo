package frameworkhelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBase implements IBaseDriver {

	public WebDriver webDriver;
	
	public  WebDriverBase(BrowserType browserType) {
		switch (browserType) {
		case Chrome:

			// System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			break;
		case FireFox:
			//System.setProperty("webdriver.gecko.driver", "src/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			webDriver.manage().window().maximize();
			break;
		default:
			break;

		}
	}
	public void TearDownWebDriver()
	{
		webDriver.quit();
	}
	
	public void TearDown() {
		webDriver.quit();
		
	}

}
