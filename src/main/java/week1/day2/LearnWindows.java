package week1.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {

		// Syntax to set web driver - chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// ClassName objectname = new ClassName();

		ChromeDriver driver = new ChromeDriver();

		// browser maximize

		driver.manage().window().maximize();

		// Open URL
		driver.get("http://www.crystalcruises.com/cruises/calendar");

		// Count the Number of links with Book Now

		List<WebElement> allBookNow = driver.findElementsByXPath("//a[text()='Book now']");

		int sizeOfList = allBookNow.size();

		System.out.println("No Of Hotel Available: " + sizeOfList);
		String currentWindow = driver.getWindowHandle();
		System.out.println("Current Window ID is : "+currentWindow);
		driver.findElementByXPath("(//a[text()='Book now'])[7]").click();
		
		Set<String> allWindows =driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>();
		allWindowsList.addAll(allWindows);
		
		String secondWindow = allWindowsList.get(1);
		driver.switchTo().window(secondWindow);
				
		String T = driver.getTitle();
		System.out.println("Title of New Page is : " + T);
		
		driver.findElementByName("ctl00$MainContent$txtGuest1FirstName").sendKeys("Jaye");
		
		Thread.sleep(3000);
		driver.close();
	}

}
