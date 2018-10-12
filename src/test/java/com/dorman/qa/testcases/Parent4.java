package com.dorman.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dorman.qa.base.TestBase;
import com.dorman.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Parent4 extends TestBase {
	TestUtil testUtil;
	DormanSearchPageTest Dormanpage;
	ExtentTest child4;
	 
	 ExtentTest child5;
	 
	 ExtentTest parent2;
	
	   
	public Parent4(){
			super();
			
	}
	
	@BeforeTest
	public void setUp() {
   

		//initialization();
		testUtil = new TestUtil();
		Dormanpage = new DormanSearchPageTest();
	
		
		
	 }
  @Test(priority=10,enabled=true)
	public void searhc(){
	
		parent2 = _extent_report.startTest("My Second Test2");
		
		 
	//	 _test_logger.log(LogStatus.FAIL, "dfd");
		// _extent_report.endTest(_test_logger); 
		 
	}
	
	@Test(priority=11,enabled=true, description="Select Spanish Language.")
	public void verifySpanishSearchResult() throws InterruptedException{
		  child4 = _extent_report.startTest("Select Spanish Language.");
		/*Dormanpage.Languageclick.click();
		
		Actions builder = new Actions( driver );
		Thread.sleep(10000);
		  builder.moveToElement(Dormanpage.Spanishclick).click().build().perform();
		  Thread.sleep(10000);
		  
		String header=  Dormanpage.header_spanish.getText();
		child1.log(LogStatus.INFO,header+" is being displayed in spanish  which is eqvivalent to Search Products in English"); 
		  
		  Dormanpage.SearchSpanishYMMPT();
		Thread.sleep(10000);
		 
		child1.log(LogStatus.INFO,Dormanpage.Submitbutton.getAttribute("value")+" is being displayed in spanish  which is eqvivalent to submit in English"); 
		  
		  Dormanpage.Submitbutton.click();
		  
			Thread.sleep(10000);
		  
		  
			
		 
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(250, 0)"); // if the element is on top.
			Thread.sleep(10000);
			
			child1.log(LogStatus.INFO,Dormanpage.viewdetails.getText()+" is being displayed in spanish  which is eqvivalent to View Details in English"); 

			Dormanpage.viewdetails.click();
			
			child1.log(LogStatus.INFO,"Below are summary items when we view details in spanish language"); 
			Thread.sleep(30000);
			for(int i=0;i<Dormanpage.summaryitem_spanish.size();i++) {
				child1.log(LogStatus.INFO,Dormanpage.summaryitem_spanish.get(i).getText()); 
				//System.out.println(Dormanpage.summaryitem.get(i).getText());
			}
			child1.log(LogStatus.INFO,Dormanpage.CheckYourFitButton.getText()+" is being displayed in spanish  which is eqvivalent to Check your Fit Button in English"); 
			Dormanpage.CheckYourFitButton.click();
			
			DormanSearch.dropdownselection(Dormanpage.Constraintdropdown, "Rear");
			Dormanpage.Submitbutton.click();
			if(Dormanpage.PartFitLabel.getText().equals("Esta pieza es un acoplamiento para su vehículo")||Dormanpage.PartFitLabel.getText().equals("Sorry, this part is not a fit for your vehicle.")) {
				child1.log(LogStatus.PASS, Dormanpage.PartFitLabel.getText()+"is being displayed so validation successful"); 
			}*/
		  
			child4.log(LogStatus.PASS,"passedtestcase1"); 
			_extent_report.endTest(child4); 
			
		  
		  
		  
		
		
	}
	
	@Test(priority=12,enabled=true)
	public void print() {
		  child5 = _extent_report.startTest("printstatement");
			child5.log(LogStatus.PASS,"passedtestcase2"); 
			_extent_report.endTest(child5);
			
	}
	
	/*@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		System.out.println(result.getStatus());
		if(ITestResult.FAILURE==result.getStatus()){
	
			try{TestUtil.takeScreenshotAtEndOfTest(result.getName());
				
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		}*/
	@AfterTest
	public void tearDown(){
		
		_test_logger1
	    .appendChild(parent2).appendChild(child4).appendChild(child5);
		
	    
		_extent_report.endTest(parent2);
		_extent_report.endTest(_test_logger1);
	
		_extent_report.flush(); 
     // _extent_report.close(); 
	}
	
}
