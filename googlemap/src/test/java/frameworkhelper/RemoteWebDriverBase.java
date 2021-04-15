package frameworkhelper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverBase {
	
	String username = "shivam.pathak";
	String accessKey = "ugJV2VblSMxE6lJmBIePZ9JTDl7hYjvfsc28zvVkju6yKdiCcc";
   
	public WebDriver ChromeRemoteDriver() throws MalformedURLException
	{
		  ChromeOptions options = new ChromeOptions();
		  
		  options.setCapability("platform", "Windows 10");
		  options.setCapability("browserName", "Chrome");
		  options.setCapability("version", "89.0"); // If this cap isn't specified, it
		  
		  options.setCapability("build", "exltestsBuild");
		  
		  options.setCapability("name", "exltestRuns");
		  options.setCapability("network", true); options.setCapability("visual",
		  true); options.setCapability("video", true); options.setCapability("console",
		  true); options.setCapability("geoLocation", "IN");
		  
		  WebDriver driver = new RemoteWebDriver( new URL("https://" + username + ":" +
		  accessKey + "@hub.lambdatest.com/wd/hub"), options);
		 
		  return driver;
	}
	
	
	public WebDriver FireFoxRemoteDriver() throws MalformedURLException
	{
		
		  FirefoxOptions options = new FirefoxOptions();
		  options.setCapability("platform", "Windows 10");
		  options.setCapability("browserName", "Firefox");
		  options.setCapability("version", "87.0"); options.setCapability("build",
		  "exltestsBuild"); options.setCapability("name", "exltestRuns");
		  options.setCapability("network", true); options.setCapability("visual",
		  true); options.setCapability("video", true); options.setCapability("console",
		  true); options.setCapability("geoLocation", "IN");
		  
		  WebDriver driver = new RemoteWebDriver( new URL("https://" + username + ":" +
		  accessKey + "@hub.lambdatest.com/wd/hub"), options);
		 

		  return driver;
	}

}
