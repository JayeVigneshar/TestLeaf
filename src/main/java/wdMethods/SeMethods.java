package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods {
	int i = 0;
	RemoteWebDriver driver = null;

	public void startApp(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void startApp(String url) {
		// TODO Auto-generated method stub

	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement ele = null;
		try {
			switch (locator) {
			case "id":
				ele = driver.findElementById(locValue);
				break;
			case "class":
				ele = driver.findElementByClassName(locValue);
				break;
			case "xpath":
				ele = driver.findElementByXPath(locValue);
				break;
			case "linktext":
				ele = driver.findElementByLinkText(locValue);
				break;
			case "name":
				ele = driver.findElementByName(locValue);
				break;

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.err.println("Unable to locate the element -" + locValue);
		} catch (WebDriverException e) {
			System.err.println("WebDriver Exception");
		}

		return ele;
	}

	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public void type(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(value);

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select dropdown = new Select(ele);
		dropdown.selectByIndex(index);

	}

	public void verifyTitle(String expectedTitle) {
	
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>();
		allWindowsList.addAll(allWindows);

		String secondWindow = allWindowsList.get(1);
		driver.switchTo().window(secondWindow);

		// Maximize New Window
		driver.manage().window().maximize();

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		if (ele.getText().equals(expectedText)) {
			System.out.println("Given text matches " + ele.getText());
		} else {
			System.out.println("Given text doesnt match " + ele.getText());
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if (ele.getText().contains(expectedText)) {
			System.out.println("Given text matches " + ele.getText());
		} else {
			System.out.println("Given text doesnt match " + ele.getText());
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if (ele.getAttribute(value).equals(attribute)) {
			System.out.println("Given text matches " + ele.getText());
		} else {
			System.out.println("Given text doesnt match " + ele.getText());
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if (ele.getAttribute(value).contains(attribute)) {
			System.out.println("Given text matches " + ele.getText());
		} else {
			System.out.println("Given text doesnt match " + ele.getText());
		}

	}

	public void verifySelected(WebElement ele) {
		if (ele.isSelected() == true) {
			System.out.println("Element " + ele + " is selected");
		} else {
			System.out.println("Element " + ele + " is not selected");
		}

	}

	public void verifyDisplayed(WebElement ele) {
		if (ele.isDisplayed() == true) {
			System.out.println("Element " + ele + " is displayed");
		} else {
			System.out.println("Element " + ele + " is displayed");
		}
	}

	public void switchToWindow(int index) {
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>();
		allWindowsList.addAll(allWindows);

		String secondWindow = allWindowsList.get(index);
		driver.switchTo().window(secondWindow);

		// Maximize New Window
		driver.manage().window().maximize();
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);

		File destFile = new File("./screenshots/NoRecordsFound", +i + ".jpg");
		i++;
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		driver.close();
	}

	public void closeAllBrowsers() {
		driver.quit();
	}

}
