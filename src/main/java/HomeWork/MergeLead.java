package HomeWork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Syntax to set web driver - chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// ClassName objectname = new ClassName();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Open URL
		driver.get("http://leaftaps.com/opentaps");

		// EnterUserName

		driver.findElementById("username").sendKeys("demosalesmanager");

		// EnterPassword
		driver.findElementById("password").sendKeys("crmsfa");

		// Click on Login
		driver.findElementByClassName("decorativeSubmit").click();

		// Click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();

		// Click on Leads Link
		driver.findElementByLinkText("Leads").click();

		// Click on Merge Leads Link
		driver.findElementByLinkText("Merge Leads").click();

		// Click on From Leads Icon Step 8

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();

		// Switch to New Window Step 9

		Set<String> allWindows = driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>();
		allWindowsList.addAll(allWindows);

		String secondWindow = allWindowsList.get(1);
		driver.switchTo().window(secondWindow);

		// Maximize New Window
		driver.manage().window().maximize();

		// Enter Lead ID Step 10

		driver.findElementByXPath("(//input)[1]").sendKeys("10014");

		// Click on Find Leads Step 11

		driver.findElementByXPath("(//*[text()='Find Leads'])[3]").click();

		// Wait for element

		Thread.sleep(2000);

		// Click on First Lead ID Step 12

		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();

		// Switch to Main Window Step 13

		allWindowsList.addAll(allWindows);

		String PreviousWindow = allWindowsList.get(0);
		driver.switchTo().window(PreviousWindow);

		String T = driver.getTitle();
		System.out.println("Title of New Page is : " + T);

		String currentWindow = driver.getWindowHandle();
		System.out.println("Current Window ID is : " + currentWindow);

		Thread.sleep(4000);

		// Click on To Leads Icon Step 14

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();

		Set<String> allNewWindows = driver.getWindowHandles();
		List<String> allNewWindowsList = new ArrayList<String>();
		allNewWindowsList.addAll(allNewWindows);

		allNewWindowsList.addAll(allNewWindows);

		String ToWindow = allNewWindowsList.get(1);
		driver.switchTo().window(ToWindow);

		driver.manage().window().maximize();

		// Enter Lead ID Step 16

		driver.findElementByXPath("(//input)[1]").sendKeys("10015");

		// Click on Find Leads Step 17

		driver.findElementByXPath("(//*[text()='Find Leads'])[3]").click();

		// Wait for element

		Thread.sleep(2000);

		// Click on First Lead ID Step 18

		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();

		// Switch to Main Window Step 19

		allWindowsList.addAll(allWindows);

		String PrimaryWindow = allWindowsList.get(0);
		driver.switchTo().window(PrimaryWindow);
		
		//Click on Merge Leads Step 20
		
		driver.findElementByClassName("buttonDangerous").click();
		
		//Switch to Alert Step 21
		
		driver.switchTo().alert().accept();
		
		//Click Find Leads link Step 22
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Enter Lead ID Step 23
		driver.findElementByXPath("//*[@name='id']").sendKeys("10014");
		
		// Click on Find Leads Step 24

		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		
		//Verify if no records Step 25
		if(driver.findElementByClassName("x-paging-info").getText().equalsIgnoreCase("No records to display"));
		System.out.println("No Records Available");
		
		//Get Screenshot Step 26
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/NoRecordsFound.jpg");
		FileUtils.copyFile(srcFile, destFile);
		
		driver.close();

		System.out.println("Execution Completed");

	}

}
