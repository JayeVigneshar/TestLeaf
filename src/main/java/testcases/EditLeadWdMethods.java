package testcases;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class EditLeadWdMethods extends ProjectMethods {

	@Test (groups={"sanity"},dependsOnGroups={"smoke"})
	public void editLead() throws InterruptedException {

		/* login(); */
		// Step 5 Click crm/sfa link

		click(locateElement("linktext", "CRM/SFA"));

		// Step 6 Click Leads link

		click(locateElement("xpath", "//a[text()='Leads']"));

		// Step 7 Click Find Leads

		click(locateElement("xpath", "//a[text()='Find Leads']"));

		// Step 8 Enter first name

		type(locateElement("xpath", "(//*[@name='firstName'])[3]"), "Jaye");

		// Step 9 Click on Find Leads Button

		click(locateElement("xpath", "//button[text()='Find Leads']"));

		Thread.sleep(3000);

		// Step 10 Click on first resulting lead
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));

		// Step 11 Verify title of the page
		verifyTitle("View Lead | opentaps CRM");

		// Step 12 Click Edit
		click(locateElement("xpath", "//a[text()='Edit']"));
		
		System.out.println("EditLeadSuccesss");
	}
}