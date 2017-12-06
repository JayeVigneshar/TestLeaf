package testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class CreateLeadWdMethods extends ProjectMethods {

	@Test (dataProvider="fetchdata")
	public void CreateLed(String FN,String LN,String CN) {
		
		/*login();*/		
		//Step 5 Click crm/sfa link
		click(locateElement("linktext","CRM/SFA"));
		//Step 6 Click Create Lead
		click(locateElement("xpath","//a[text()='Create Lead']"));
		//Step 7 Enter Company Name
		type(locateElement("id","createLeadForm_companyName"),CN);
		//Step 8 Enter First Name
		type(locateElement("id","createLeadForm_firstName"),FN);
		//Step 9 Enter Last Name
		type(locateElement("id","createLeadForm_lastName"),LN);
		//Step 10 Choose Source
		selectDropDownUsingIndex(locateElement("id","createLeadForm_dataSourceId"),3);
		//Step 11 Choose Marketing Campaign
		selectDropDownUsingText(locateElement("id","createLeadForm_marketingCampaignId"),"Automobile");
		//Step 12 Enter Phone Number
		type(locateElement("id","createLeadForm_primaryPhoneNumber"),"7010412313");
		//Step 13 Enter Email Address
		type(locateElement("id","createLeadForm_primaryEmail"),"test@testing.com");
		//Step 14 Click Create Lead
		click(locateElement("name","submitButton"));
		//Step 15 Verify First Name
		verifyExactText(locateElement("id","viewLead_firstName_sp"),FN);
		System.out.println("Create Succesful");
		//Step 16 Close
		/*close();*/
	}
@DataProvider(name="fetchdata")
public String[][] getData()
{
	String[][] data=new String[3][3];
	data[0][0]="Jaye";
	data[0][1]="V";
	data[0][2]="CTS";
	data[1][0]="Vignesh";
	data[1][1]="A";
	data[1][2]="CTS";
	data[2][0]="Hari";
	data[2][1]="A";
	data[2][2]="CTS";
return data;	
}
}








