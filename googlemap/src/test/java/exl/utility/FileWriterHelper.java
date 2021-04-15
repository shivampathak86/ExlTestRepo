package exl.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileWriterHelper {

	private WebDriver driver;

	private By routeTitleCollection = By.xpath("//h1[contains(@id,'section-directions-trip-title')]");
	private By routeTimeCollection = By
			.xpath("//*[@class ='section-directions-trip-duration delay-light']//span[contains(.,'hr')]");
	private By routeMileCollection = By.xpath(
			"//*[@class ='section-directions-trip-distance section-directions-trip-secondary-text']//child::div");

	public FileWriterHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void StoreRouteInformation(String Filename) throws IOException {
		List<String> routeTitles = getRouteInformation(routeTitleCollection);

		List<String>  routeTimes = getRouteInformation(routeTimeCollection);

		List<String>  routeMiles = getRouteInformation(routeMileCollection);

		List<RouteInformationMap> routeInfoMap = new ArrayList<>();

		routeInfoMap.add(new RouteInformationMap(routeTitles.get(0), routeTimes.get(0), routeMiles.get(0)));
		routeInfoMap.add(new RouteInformationMap(routeTitles.get(1), routeTimes.get(1), routeMiles.get(1)));
		routeInfoMap.add(new RouteInformationMap(routeTitles.get(2), routeTimes.get(2), routeMiles.get(2)));
         String FilePath = "src/"+Filename;
		File file = new File(FilePath);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		try (FileWriter f = new FileWriter(FilePath, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {
			for (RouteInformationMap item : routeInfoMap) {
				p.println(item.routeTitle + '\t' + item.routeTime + '\t' + item.routeMiles);
			}
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private List<String> getRouteInformation(By locatorValue) {
		List<WebElement> routesTitles = driver.findElements(locatorValue);
		List<String> routeTitleCollection = routesTitles.stream().map(r -> r.getText()).collect(Collectors.toList());
		return routeTitleCollection;
	}

	private class RouteInformationMap {

		String routeTitle;
		String routeTime;
		String routeMiles;

		public RouteInformationMap(String title, String time, String mile) {
			this.routeTitle = title;
			this.routeTime = time;
			this.routeMiles = mile;

		}
	}
}
