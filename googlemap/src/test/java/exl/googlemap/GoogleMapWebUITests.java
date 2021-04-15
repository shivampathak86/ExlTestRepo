package exl.googlemap;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exl.pageobjectmodel.DestinationPage;
import exl.pageobjectmodel.MapHomePage;
import exl.utility.FileWriterHelper;
import frameworkhelper.BrowserType;
import frameworkhelper.IBaseDriver;
import frameworkhelper.RemoteWebDriverBase;
import frameworkhelper.WebDriverBase;

public class GoogleMapWebUITests {

	private WebDriverWait wait;
	
	private IBaseDriver baseDriver;


 @AfterMethod
	public void TearDown() {
		baseDriver.TearDown();
	}

	@Test
	public void Given_GoogleMap_Page_Is_Opened_In_FireFox_When_Search_Route_Between_Cities_Then_RouteOptions_Returned_Should_Be_Eql_Expected_RouteOptions_And_Route_Data_Written_To_File()
			throws IOException {

		// InitLocalRun(BrowserType.FireFox);
		/*
		 * the value of latitude and longitude is different in Chrome and Firefox This
		 * is default behavior of map web app this is why data driver method for passing
		 * latitude and longitude is created
		 */
		RunTest(InitLocalRun(BrowserType.FireFox), "route_FF.txt", "37.7576948", "-122.4726193");

		//RunTest(InitRemoteRun(BrowserType.FireFox), "route_FF.txt", "37.7576948", "-122.4726193");
	}

	@Test

	public void Given_GoogleMap_Page_Is_Opened_In_Chrome_When_Search_Route_Between_Cities_Then_RouteOptions_Returned_Should_Be_Eql_Expected_RouteOptions_And_Route_Data_Written_To_File()
			throws IOException {
		/*
		 * the value of latitude and longitude is different in Chrome and Firefox This
		 * is default behavior of map web app this is why data driver method for passing
		 * latitude and longitude is created
		 */
		RunTest(InitLocalRun(BrowserType.Chrome), "route_Chrome.txt", "37.7577627", "-122.4726194");

		//RunTest(InitRemoteRun(BrowserType.Chrome), "route_Chrome.txt", "37.7577627", "-122.4726194");
	}

	/*
	 * Private methods
	 */
	private WebDriver InitLocalRun(BrowserType browserType) {
		WebDriverBase localDriver = new WebDriverBase(browserType);
		baseDriver = localDriver;	
		wait = new WebDriverWait(localDriver.webDriver, 10);
		return localDriver.webDriver;
	}

	private WebDriver InitRemoteRun(BrowserType browserType) throws IOException {
		RemoteWebDriverBase remoteDriver = new RemoteWebDriverBase(browserType);
		baseDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver.webDriver, 10);
		return remoteDriver.webDriver;
	}

	private void RunTest(WebDriver driver, String fileName, String latitude, String longitude) throws IOException {
		driver.get("https://www.google.com/maps");
		MapHomePage homePage = new MapHomePage(driver, wait);
		homePage.SearchDestination("San Francisco, California");

		DestinationPage destinationPage = new DestinationPage(driver, wait, "maps/place/San+Francisco", latitude,
				longitude);

		Assert.assertTrue(destinationPage.HasExpectedCoordinates());

		destinationPage.ClickOnDirectionButton();

		destinationPage.SearchRouteOptions("Chico, California");
		destinationPage.TravelByCar();

		Assert.assertTrue(destinationPage.HasExpectedRouteOptions(3));

		FileWriterHelper fileHelper = new FileWriterHelper(driver);
		fileHelper.StoreRouteInformation(fileName);
	}

}
