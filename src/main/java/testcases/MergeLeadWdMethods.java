package testcases;

import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class MergeLeadWdMethods extends SeMethods {
	@Test(groups={"regression"},dependsOnGroups={"sanity"})
	public void mergeLead() throws InterruptedException {
				
	System.out.println("MergeLeadSuccss");

}
}