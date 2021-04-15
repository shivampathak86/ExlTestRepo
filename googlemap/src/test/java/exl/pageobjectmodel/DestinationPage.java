package exl.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DestinationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private String urlDefination;
	private String latituteValue;
	private String longituteValue;
	private By directionButton = By.xpath("//div//button[contains(@data-value,'Directions')]");

	private By startingPoint = By.xpath("//div//input[contains(@aria-label,'Choose starting point')]");

	private By travelByCar = By.cssSelector("img[aria-label='Driving']");

	private By routeOptions = By.cssSelector(".section-directions-trip-description");

	public DestinationPage(WebDriver driver, WebDriverWait wait, String UrlDefination, String LattituteValue,
			String LongituteValue) {
		this.driver = driver;
		this.wait = wait;
		this.urlDefination = UrlDefination;
		this.longituteValue = LongituteValue;
		this.latituteValue = LattituteValue;

	}

	private String getPageUrl() {
		wait.until(ExpectedConditions.urlContains(urlDefination));

		return driver.getCurrentUrl();

	}

	public Boolean HasExpectedCoordinates() {

		return getPageUrl().contains(latituteValue) && getPageUrl().contains(longituteValue);
	}

	public void ClickOnDirectionButton() {
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(directionButton));
		btn.click();

	}

	public void SearchRouteOptions(String destinationPlace) {
		WebElement destinationField = wait.until(ExpectedConditions.presenceOfElementLocated(startingPoint));
		destinationField.click();
		destinationField.sendKeys(destinationPlace);
	}

	public void TravelByCar() {
		driver.findElement(travelByCar).click();

	}

	private List<WebElement> GetAllRouteOption() {
		List<WebElement> listOfRoutes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(routeOptions));

		return listOfRoutes;
	}

	public Boolean HasExpectedRouteOptions(int expecteRouteOptions) {
		return GetAllRouteOption().size() == expecteRouteOptions;
	}

}
