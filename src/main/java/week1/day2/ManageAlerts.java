package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class ManageAlerts {
	
	public static void main (String[] args) throws InterruptedException
	{
		// Syntax to set web driver - chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		// ClassName objectname = new ClassName();

		ChromeDriver driver = new ChromeDriver();
		
		//browser maximize
		
		driver.manage().window().maximize();

		// Open URL
		driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
		
		//Click on Button
		driver.findElementByXPath("//input[@value='Say my name!']").click();
		
		//Enter your Name
		driver.switchTo().alert().sendKeys("Jaye");
		
		//Accept the Alert
		driver.switchTo().alert().accept();
		
		//Verify if Jaye is in alert
		
		String getname= driver.switchTo().alert().getText();
		//System.out.println(getname);
		
		if (getname.contains("Jaye")) {
			
			System.out.println("Contains String Jaye");
			
		}
		
		//Accept the second alert
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		
		driver.close();
	}

}
