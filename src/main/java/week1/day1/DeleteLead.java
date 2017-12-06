package week1.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
	
	public static void main(String[]args) throws InterruptedException{
		//TODO Auto generated method stub
		
		//Syntax to set web driver - chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//ClassName objectname = new ClassName();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Open URL
		driver.get("http://leaftaps.com/opentaps");
		
		//EnterUserName
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		
		//EnterPassword
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click on Login
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click Leads link
		
		driver.findElementByXPath("//a[text()='Leads']").click();
		
		//Click Find Leads link
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Click on Phone
		
		driver.findElementByXPath("//span[text()='Phone']").click();	
		
		//Enter phone number
		
		driver.findElementByName("phoneNumber").sendKeys("9677794764");
		
		//Click on Find Leads
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		//Click on First Lead ID
		
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		
		//Click on Delete
		
		//driver.findElementByXPath("//a[text()='Delete']").click(); Can Be Identified with link text
		
		driver.findElementByLinkText("Delete").click();
		
		//close the browser

		driver.close();
		
		
		
		
		
		
		
		
		
	
	
	}
	}

		
		
		
		
		//crmsfa
		
	