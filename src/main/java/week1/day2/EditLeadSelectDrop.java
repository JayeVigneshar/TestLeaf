package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadSelectDrop {

	public static void main(String[] args) throws InterruptedException {

		// Syntax to set web driver - chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// ClassName objectname = new ClassName();

		ChromeDriver driver = new ChromeDriver();

		// browser maximize

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

		// Click Leads link
		driver.findElementByXPath("//*[@name='id']").sendKeys("10066");

		// Click on Find Leads

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		driver.findElementByXPath("//a[text()='Leads']").click();

		// Click Find Leads link

		driver.findElementByXPath("//a[text()='Find Leads']").click();

		// Enter Lead ID in 10066

	}

}
