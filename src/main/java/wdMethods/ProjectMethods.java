package wdMethods;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectMethods extends SeMethods {
	@BeforeMethod(groups={"general"})
	@Parameters({"browser","url","id","pw"})
	public void login(String brw,String url, String id,String pw) {
		// Step 1 Launch Browser
		startApp(brw, url);
		// Step 2 Enter User Name
		WebElement userNameEle = locateElement("id", "username");
		type(userNameEle, id);
		// Step 3 Enter Password
		type(locateElement("id", "password"), pw);
		// Step 4 Click Login
		click(locateElement("class", "decorativeSubmit"));
	}

	@AfterMethod(groups={"general"})
	public void close() {
		closeBrowser();
	}
}
