package TestSuite;

import org.testng.annotations.Test;

import Objects.CovidStateReport;
import Objects.LaunchBrowser;

public class RunE2E extends LaunchBrowser{
	
	@Test
	public void RunTest() {
		
		launchWebsite();
		
		
		
		//Creating instance of CovidStateReport
		CovidStateReport report = new CovidStateReport(driver);
		report.selectState();
		report.getCaseData();
	}
	
}
