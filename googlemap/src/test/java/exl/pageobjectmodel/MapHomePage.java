package exl.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapHomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private By searchInput = By.id("searchboxinput");

	public MapHomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void SearchDestination(String desitnation) {
		WebElement destination = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));
		destination.sendKeys(Keys.chord(desitnation), Keys.chord(Keys.ENTER));

	}
}
